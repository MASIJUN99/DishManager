package com.example.controller;

import com.example.pojo.Daily;
import com.example.pojo.DailyNum;
import com.example.pojo.Dish;
import com.example.pojo.Recipe;
import com.example.service.DailyNumService;
import com.example.service.DailyService;
import com.example.service.DishService;
import com.example.service.RecipeService;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyDateUtils;
import com.example.utils.MyStringToDateConverter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import javax.xml.bind.SchemaOutputResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DailyController {

  @Autowired
  DishService dishService;
  @Autowired
  RecipeService recipeService;
  @Autowired
  DailyService dailyService;
  @Autowired
  DailyNumService dailyNumService;
  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();
  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();
  MyDateUtils myDateUtils = new MyDateUtils();

  @RequestMapping("/getDaily")
  public String getDaily(String dateStr, Model model) {
    Date date = myStringToDateConverter.convert(dateStr);
    List<Daily> dailies = dailyService.selectByDate(date);
    model.addAttribute("dailies", dailies);
    return "daily/daily";
  }

  @GetMapping("/delDailyDish/{id}")
  public String delDish(@PathVariable("id") int id, String date, int time, String url) {
    int delId = dailyService.selectByDishIdInDateAndTime(id, date, time).getId();
    dailyService.deleteById(delId);
    System.out.println("删除了" + date + "的第" + id);
    return "redirect:/" + url;
  }

  @RequestMapping("/addDailyDish")
  public String addDish(Integer addDishId, String addDate, Integer addTime, String url) {
    dailyService.insertDishInDateAndTime(addDate, addTime, addDishId);
    return "redirect:/" + url;
  }

  @RequestMapping("/changeDailyDish")
  public String changeDish(String changeDate, Integer changeTime, Integer oldDishId,
      Integer changeDishId, String url) {
//    System.out.println(changeDate);
//    System.out.println(changeTime);
//    System.out.println(changeDishId);
//    System.out.println(oldDishId);
    Daily daily = dailyService.selectByDishIdInDateAndTime(oldDishId, changeDate, changeTime);
    daily.setDish(changeDishId);
    dailyService.updateById(daily);
    System.out.println(url);
    return "redirect:/" + url;
  }


  @GetMapping("/queryDate")
  public String queryDaily(String dateStr, Model model) {


    System.out.println(dateStr);

    Date date = myStringToDateConverter.convert(dateStr);
    // 获得前一天下一天
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(Calendar.DATE, 1);
    Date next = cal.getTime();
    cal.add(Calendar.DATE, -2);
    Date prev = cal.getTime();

    // 按天顿查好
    List<Daily> dailiesBreakfast = dailyService.selectByDateAndTime(date, Daily.BREAKFAST);
    List<Daily> dailiesLunch = dailyService.selectByDateAndTime(date, Daily.LUNCH);
    List<Daily> dailiesDinner = dailyService.selectByDateAndTime(date, Daily.DINNER);
    List<Daily> dailyAllDishes = dailyService.selectByDate(date);

    // 按顿查好，并放入dish
    List<Dish> dishesBreakfast = new ArrayList<>();
    List<Dish> dishesLunch = new ArrayList<>();
    List<Dish> dishesDinner = new ArrayList<>();
    List<Dish> allDishes = new ArrayList<>();
    for (Daily daily : dailiesBreakfast) {
      Dish dish = dishService.selectById(daily.getDish());
      allDishes.add(dish);
      dishesBreakfast.add(dish);
    }
    for (Daily daily : dailiesLunch) {
      Dish dish = dishService.selectById(daily.getDish());
      allDishes.add(dish);
      dishesLunch.add(dish);
    }
    for (Daily daily : dailiesDinner) {
      Dish dish = dishService.selectById(daily.getDish());
      allDishes.add(dish);
      dishesDinner.add(dish);
    }

    allDishes.sort((x, y) -> Integer.compare(x.getCategory(), y.getCategory()));
    dishesBreakfast.sort((x, y) -> Integer.compare(x.getCategory(), y.getCategory()));
    dishesLunch.sort((x, y) -> Integer.compare(x.getCategory(), y.getCategory()));
    dishesDinner.sort((x, y) -> Integer.compare(x.getCategory(), y.getCategory()));

    String url = "queryDate?dateStr=" + dateStr;

    // 放到请求体

    model.addAttribute("prev", myDateToStringConverter.convert(prev));
    model.addAttribute("next", myDateToStringConverter.convert(next));
    model.addAttribute("url", url);
    model.addAttribute("date", dateStr);
    model.addAttribute("breakfast", dishesBreakfast);
    model.addAttribute("lunch", dishesLunch);
    model.addAttribute("dinner", dishesDinner);
    model.addAttribute("dishes", dishService.selectAll());


    // 计算人数 菜量
    Integer num = dailyNumService.selectByDate(date).getNum();

    Recipe sum = new Recipe();
    for (Dish dish : allDishes) {
      Recipe recipe = recipeService.selectById(dish.getId());
      sum.add(recipe);
    }
    sum.mul(num);
    sum.mul(0.0125);  // 除以8
    model.addAttribute("num", num);  // 把人数放进去
//    model.addAttribute("recipe", sum);


    ArrayList<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < Recipe.ZH_CN_NAME.length; i++) {
      indexList.add(i);
    }
    model.addAttribute("indexList", indexList);

    model.addAttribute("recipeNameList", Recipe.ZH_CN_NAME);
    model.addAttribute("recipeList", sum.flatten());

    return "daily";
  }

  @RequestMapping("/changePeopleNum")
  public String changePeopleNum(int num, String date) {
    DailyNum dailyNum = dailyNumService.selectByDate(date);
    dailyNum.setNum(num);
    dailyNumService.updateById(dailyNum);

    String url = "queryDate?dateStr=" + date;
    return "redirect:/" + url;
  }

  @RequestMapping("/deleteAll")
  public String deleteAll(String dateDel, String urlDel) {
    System.out.println(dateDel);
    System.out.println(urlDel);
    dailyService.deleteByDate(dateDel);
    return "redirect:/" + urlDel;
  }

  @RequestMapping("/randomDailyDishes")
  public String randomDailyDishes(
      int breakfastMeat, int breakfastVegetable, int breakfastMixed, int breakfastSoup,
      int lunchMeat, int lunchVegetable, int lunchMixed, int lunchSoup,
      int dinnerMeat, int dinnerVegetable, int dinnerMixed, int dinnerSoup,
      String url, String dateStr
  ) {
//    打印一下看看参数传递结果
//    System.out.println(breakfastMeat);
//    System.out.println(breakfastVegetable);
//    System.out.println(breakfastMixed);
//    System.out.println(lunchMeat);
//    System.out.println(lunchVegetable);
//    System.out.println(lunchMixed);
//    System.out.println(dinnerMeat);
//    System.out.println(dinnerVegetable);
//    System.out.println(dinnerMixed);
//    System.out.println(url);
    System.out.println(dateStr);

    List<Dish> dishVegetable = dishService.selectByCategory(Dish.VEGETABLE);
    List<Dish> dishMeat = dishService.selectByCategory(Dish.MEAT);
    List<Dish> dishMixed = dishService.selectByCategory(Dish.MIXED);
    List<Dish> dishSoup = dishService.selectByCategory(Dish.SOUP);

    // 获得各个类别的总数量
    int vegetableLength = breakfastVegetable + lunchVegetable + dinnerVegetable;
    int meatLength = breakfastMeat + lunchMeat + dinnerMeat;
    int mixedLength = breakfastMixed + lunchMixed + dinnerMixed;
    int soupLength = breakfastSoup + lunchSoup + dinnerSoup;

    if (vegetableLength > dishVegetable.size() ||
        meatLength > dishMeat.size() ||
        mixedLength > dishMixed.size() ||
        soupLength > dishSoup.size()
    ) {
      // 长度不足以保证不重复
      return "redirect:/index"; // 出错！
    }

    // 生成不重复随机序列
    Random r = new Random(1);
    List<Integer> vegetables = new ArrayList(vegetableLength);
    while (vegetables.size() < vegetableLength) {
      int rand = r.nextInt(dishVegetable.size());
      if (vegetables.contains(rand)) {
        continue;
      }
      vegetables.add(rand);
    }
    List<Integer> meats = new ArrayList(meatLength);
    while (meats.size() < meatLength) {
      int rand = r.nextInt(dishMeat.size());
      if (meats.contains(rand)) {
        continue;
      }
      meats.add(rand);
    }
    List<Integer> mixeds = new ArrayList(mixedLength);
    while (mixeds.size() < mixedLength) {
      int rand = r.nextInt(dishMixed.size());
      if (mixeds.contains(rand)) {
        continue;
      }
      mixeds.add(rand);
    }
    List<Integer> soups = new ArrayList(soupLength);
    while (soups.size() < soupLength) {
      int rand = r.nextInt(dishSoup.size());
      if (soups.contains(rand)) {
        continue;
      }
      soups.add(rand);
    }

    int idx = 0;
    while (idx < vegetableLength) {
      Daily daily = null;
      if (idx < breakfastVegetable) {
        daily = new Daily(dateStr, Daily.BREAKFAST, dishVegetable.get(vegetables.get(idx)).getId());
      } else if (idx < lunchVegetable + breakfastVegetable) {
        daily = new Daily(dateStr, Daily.LUNCH, dishVegetable.get(vegetables.get(idx)).getId());
      } else if (idx < dinnerVegetable + lunchVegetable + breakfastVegetable) {
        daily = new Daily(dateStr, Daily.DINNER, dishVegetable.get(vegetables.get(idx)).getId());
      }
      System.out.println(daily);
      dailyService.insert(daily);
      idx += 1;
    }
    idx = 0;
    while (idx < meatLength) {
      Daily daily = null;
      if (idx < breakfastMeat) {
        daily = new Daily(dateStr, Daily.BREAKFAST, dishMeat.get(meats.get(idx)).getId());
      } else if (idx < lunchMeat + breakfastMeat) {
        daily = new Daily(dateStr, Daily.LUNCH, dishMeat.get(meats.get(idx)).getId());
      } else if (idx < dinnerMeat + lunchMeat + breakfastMeat) {
        daily = new Daily(dateStr, Daily.DINNER, dishMeat.get(meats.get(idx)).getId());
      }
      System.out.println(daily);
      dailyService.insert(daily);
      idx += 1;
    }
    idx = 0;
    while (idx < mixedLength) {
      Daily daily = null;
      if (idx < breakfastMixed) {
        daily = new Daily(dateStr, Daily.BREAKFAST, dishMixed.get(mixeds.get(idx)).getId());
      } else if (idx < lunchMixed + breakfastMixed) {
        daily = new Daily(dateStr, Daily.LUNCH, dishMixed.get(mixeds.get(idx)).getId());
      } else if (idx < dinnerMixed + lunchMixed + breakfastMixed) {
        daily = new Daily(dateStr, Daily.DINNER, dishMixed.get(mixeds.get(idx)).getId());
      }
      System.out.println(daily);
      dailyService.insert(daily);
      idx += 1;
    }
    idx = 0;
    while (idx < soupLength) {
      Daily daily = null;
      if (idx < breakfastSoup) {
        daily = new Daily(dateStr, Daily.BREAKFAST, dishSoup.get(soups.get(idx)).getId());
      } else if (idx < lunchSoup + breakfastSoup) {
        daily = new Daily(dateStr, Daily.LUNCH, dishSoup.get(soups.get(idx)).getId());
      } else if (idx < dinnerSoup + lunchSoup + breakfastSoup) {
        daily = new Daily(dateStr, Daily.DINNER, dishSoup.get(soups.get(idx)).getId());
      }
      System.out.println(daily);
      dailyService.insert(daily);
      idx += 1;
    }


    return "redirect:/" + url;
  }

  @RequestMapping("/queryBetweenTwoDates")
  public String randomBetweenTwoDates(String dateStart, String dateEnd, Model model) {
    Date start = myStringToDateConverter.convert(dateStart);
    Date end = myStringToDateConverter.convert(dateEnd);
    Calendar cal = Calendar.getInstance();
    Calendar stop = Calendar.getInstance();
    cal.setTime(start);
    stop.setTime(end);
    stop.add(Calendar.DATE, 1);

    // 日期内的原材料总和
    Recipe sum = new Recipe();

    // 一个及其复杂的map，我都不想解释，屎山
    Map<String, Map<Integer, List<Dish>>> map = new TreeMap<>();
    while (cal.before(stop)) {

      Recipe dailySum = new Recipe();

      Date date = cal.getTime();
      String dateStr = myDateToStringConverter.convert(date);

      Map<Integer, List<Dish>> mapOfDay = new HashMap<>();
      // 获取date日期早餐列表
      List<Daily> dailyBreakfast = dailyService.selectByDateAndTime(date, Daily.BREAKFAST);
      List<Dish> breakfast = new ArrayList<>();
      for (Daily daily : dailyBreakfast) {
        Dish dish = dishService.selectById(daily.getDish());
        breakfast.add(dish);
        // 获取当前菜的菜谱，然后累加
        dailySum.add(recipeService.selectById(dish.getRecipe()));
      }
      mapOfDay.put(Daily.BREAKFAST, breakfast);

      // 获取date日期午餐列表
      List<Daily> dailyLunch = dailyService.selectByDateAndTime(date, Daily.LUNCH);
      List<Dish> lunch = new ArrayList<>();
      for (Daily daily : dailyLunch) {
        Dish dish = dishService.selectById(daily.getDish());
        lunch.add(dish);
        // 获取当前菜的菜谱，然后累加
        dailySum.add(recipeService.selectById(dish.getRecipe()));
      }
      mapOfDay.put(Daily.LUNCH, lunch);
      // 获取date日期晚餐列表
      List<Daily> dailyDinner = dailyService.selectByDateAndTime(date, Daily.DINNER);
      List<Dish> dinner = new ArrayList<>();
      for (Daily daily : dailyDinner) {
        Dish dish = dishService.selectById(daily.getDish());
        dinner.add(dish);
        // 获取当前菜的菜谱，然后累加
        dailySum.add(recipeService.selectById(dish.getRecipe()));
      }
      mapOfDay.put(Daily.DINNER, dinner);
      cal.add(Calendar.DATE, 1);
      map.put(dateStr, mapOfDay);

      // 获取当日就餐人数，然后乘1/80，乘人数，加到总和sum上
      int num = dailyNumService.selectByDate(date).getNum();
      dailySum.mul(0.0125);
      dailySum.mul(num);
      sum.add(dailySum);
    }

    System.out.println(map);
    model.addAttribute("maps", map);
    model.addAttribute("date", myDateToStringConverter.convert(new Date()));
    model.addAttribute("dateStart", dateStart);
    model.addAttribute("dateEnd", dateEnd);

    ArrayList<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < Recipe.ZH_CN_NAME.length; i++) {
      indexList.add(i);
    }
    model.addAttribute("indexList", indexList);

    model.addAttribute("recipeNameList", Recipe.ZH_CN_NAME);
    model.addAttribute("recipeList", sum.flatten());

    return "date";
  }

  @RequestMapping("/randomBetweenTwoDates")
  public String randomBetweenTwoDates(String start, String end, int cycle,
      int breakfastMeat, int breakfastVegetable, int breakfastMixed, int breakfastSoup,
      int lunchMeat, int lunchVegetable, int lunchMixed, int lunchSoup,
      int dinnerMeat, int dinnerVegetable, int dinnerMixed, int dinnerSoup
      ) {
//    System.out.println(cycle);
//    System.out.println(breakfastVegetable);
//    System.out.println(breakfastMeat);
//    System.out.println(breakfastMixed);
//
//    System.out.println(lunchVegetable);
//    System.out.println(lunchMeat);
//    System.out.println(lunchMixed);
//
//    System.out.println(dinnerVegetable);
//    System.out.println(dinnerMeat);
//    System.out.println(dinnerMixed);
//
//    System.out.println(breakfastSoup);
//    System.out.println(lunchSoup);
//    System.out.println(dinnerSoup);

    // TODO:后期添加类别
    int breakfastNum = breakfastMeat + breakfastVegetable + breakfastMixed;
    int lunchNum     = lunchMeat     + lunchVegetable     + lunchMixed;
    int dinnerNum    = dinnerMeat    + dinnerVegetable    + dinnerMixed;

    int vegetableLength = breakfastVegetable + lunchVegetable + dinnerVegetable;
    int meatLength      = breakfastMeat      + lunchMeat      + dinnerMeat;
    int mixedLength     = breakfastMixed     + lunchMixed     + dinnerMixed;
    int soupLength      = breakfastSoup      + lunchSoup      + dinnerSoup;

    List<Dish> allVegetables = dishService.selectByCategory(Dish.VEGETABLE);
    List<Dish> allMeats = dishService.selectByCategory(Dish.MEAT);
    List<Dish> allMixed = dishService.selectByCategory(Dish.MIXED);
    List<Dish> allSoup  = dishService.selectByCategory(Dish.SOUP);

    if (vegetableLength * cycle > allVegetables.size() ||
        meatLength * cycle > allMeats.size() ||
        mixedLength * cycle > allMixed.size() ||
        soupLength * cycle > allSoup.size()
    ) {
      // 循环周期大于总长度，直接rollback
      System.out.println("rollback");
      return "redirect:/index";
    }

    List<Date> dateBetween = myDateUtils.getDateBetween(start, end);
    System.out.println(dateBetween);
    for (Date date : dateBetween) {
      // 获得前后三天
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DATE, -cycle);
      // 开始获得set
      Set<Integer> set = new HashSet<>();
      for (int i = 0; i < cycle * 2; i++) {
        List<Daily> dailies = dailyService.selectByDate(cal.getTime());
        for (Daily daily : dailies) {
          set.add(daily.getDish());
        }
        cal.add(Calendar.DATE, 1);
      }
      // 开始随机生成id
      Random r = new Random(date.getTime()); // 这里有坑

      for (int i = 0; i < vegetableLength; i++) {
        int idx = 0;
        while (true) {
          // 当id重复，在生成一个随机数
          int num = r.nextInt(allVegetables.size());
          int dishId = allVegetables.get(num).getId();
          if (set.contains(dishId) && idx < 20) {
            // 记录重复次数，重复次数过多认定没办法协调了
            idx += 1;
          } else {
            int time;
            if (i < breakfastVegetable) {
              time = Daily.BREAKFAST;
            } else if (i < breakfastVegetable + lunchVegetable) {
              time = Daily.LUNCH;
            } else {
              time = Daily.DINNER;
            }
            Daily daily = new Daily(myDateToStringConverter.convert(date), time, dishId);
            set.add(dishId);
            dailyService.insert(daily);
            break;
          }
        }
      }

      for (int i = 0; i < meatLength; i++) {
        int idx = 0;
        while (true) {
          // 当id重复，在生成一个随机数
          int num = r.nextInt(allMeats.size());
          int dishId = allMeats.get(num).getId();
          if (set.contains(dishId) && idx < 20) {
            // 记录重复次数，重复次数过多认定没办法协调了
            idx += 1;
          } else {
            int time;
            if (i < breakfastMeat) {
              time = Daily.BREAKFAST;
            } else if (i < breakfastMeat + lunchMeat) {
              time = Daily.LUNCH;
            } else {
              time = Daily.DINNER;
            }
            Daily daily = new Daily(myDateToStringConverter.convert(date), time, dishId);
            set.add(dishId);
            dailyService.insert(daily);
            break;
          }
        }
      }

      for (int i = 0; i < mixedLength; i++) {
        int idx = 0;
        while (true) {
          // 当id重复，在生成一个随机数
          int num = r.nextInt(allMixed.size());
          int dishId = allMixed.get(num).getId();
          if (set.contains(dishId) && idx < 20) {
            // 记录重复次数，重复次数过多认定没办法协调了
            idx += 1;
          } else {
            int time;
            if (i < breakfastMixed) {
              time = Daily.BREAKFAST;
            } else if (i < breakfastMixed + lunchMixed) {
              time = Daily.LUNCH;
            } else {
              time = Daily.DINNER;
            }
            Daily daily = new Daily(myDateToStringConverter.convert(date), time, dishId);
            set.add(dishId);
            dailyService.insert(daily);
            break;
          }
        }
      }

      for (int i = 0; i < soupLength; i++) {
        int idx = 0;
        while (true) {
          // 当id重复，在生成一个随机数
          int num = r.nextInt(allSoup.size());
          int dishId = allSoup.get(num).getId();
          if (set.contains(dishId) && idx < 20) {
            // 记录重复次数，重复次数过多认定没办法协调了
            idx += 1;
          } else {
            int time;
            if (i < breakfastSoup) {
              time = Daily.BREAKFAST;
            } else if (i < breakfastSoup + lunchSoup) {
              time = Daily.LUNCH;
            } else {
              time = Daily.DINNER;
            }
            Daily daily = new Daily(myDateToStringConverter.convert(date), time, dishId);
            set.add(dishId);
            dailyService.insert(daily);
            break;
          }
        }
      }

    }

    return "redirect:/queryBetweenTwoDates?dateStart=" + start + "&dateEnd=" + end;
  }





}
