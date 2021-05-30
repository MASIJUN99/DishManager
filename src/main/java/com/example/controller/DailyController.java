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
import java.util.List;
import java.util.Random;
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
    System.out.println(changeDate);
    System.out.println(changeTime);
    System.out.println(changeDishId);
    System.out.println(oldDishId);
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
    List<Daily> dailiesBreakfast = dailyService.selectByDateAndTime(date, 1);
    List<Daily> dailiesLunch = dailyService.selectByDateAndTime(date, 2);
    List<Daily> dailiesDinner = dailyService.selectByDateAndTime(date, 3);
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
    model.addAttribute("num", num);  // 把人数放进去
    model.addAttribute("recipe", sum);
    model.addAttribute("dishName", Recipe.ZH_CN_NAME);

    return "daily";
  }

  @RequestMapping("/changePeopleNum")
  public String changePeopleNum(int num, String date) {
    DailyNum dailyNum = dailyNumService.selectByDate(date);
    dailyNum.setNum(num);
    dailyNumService.updateById(dailyNum);


    String url = "queryDate?dateStr=" + date;
    System.out.println(url);
    return "redirect:/" + url;
  }

  @RequestMapping("/randomDailyDishes")
  public String randomDailyDishes(
      int breakfastMeat, int breakfastVegetable, int breakfastMixed,
      int lunchMeat, int lunchVegetable, int lunchMixed,
      int dinnerMeat, int dinnerVegetable, int dinnerMixed,
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

    // 获得各个类别的总数量
    int vegetableLength = breakfastVegetable + lunchVegetable + dinnerVegetable;
    int meatLength = breakfastMeat + lunchMeat + dinnerMeat;
    int mixedLength = breakfastMixed + lunchMixed + dinnerMixed;
    if (vegetableLength > dishVegetable.size() ||
        meatLength > dishMeat.size() ||
        mixedLength > dishMixed.size()
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


    return "redirect:/" + url;
  }

  @RequestMapping("/queryBetweenTwoDates")
  public String randomBetweenTwoDates(String dateStart, String dateEnd, Model model) {
    Date start = myStringToDateConverter.convert(dateStart);
    Date end = myStringToDateConverter.convert(dateEnd);
    Calendar cal = Calendar.getInstance();
    cal.setTime(start);

    List<List<Dish>> allBreakfast = new ArrayList<>();
    List<List<Dish>> allLunch = new ArrayList<>();
    List<List<Dish>> allDinner = new ArrayList<>();
    List<String> dateList = new ArrayList<>();
    while (cal.after(end)) {
      Date date = cal.getTime();
      dateList.add(myDateToStringConverter.convert(date));
      // 获取date日期早餐列表
      List<Daily> dailyBreakfast = dailyService.selectByDateAndTime(date, Daily.BREAKFAST);
      List<Dish> breakfast = new ArrayList<>();
      for (Daily daily : dailyBreakfast) {
        breakfast.add(dishService.selectById(daily.getDish()));
      }
      allBreakfast.add(breakfast);
      // 获取date日期午餐列表
      List<Daily> dailyLunch = dailyService.selectByDateAndTime(date, Daily.LUNCH);
      List<Dish> lunch = new ArrayList<>();
      for (Daily daily : dailyLunch) {
        lunch.add(dishService.selectById(daily.getDish()));
      }
      allLunch.add(lunch);
      // 获取date日期晚餐列表
      List<Daily> dailyDinner = dailyService.selectByDateAndTime(date, Daily.DINNER);
      List<Dish> dinner = new ArrayList<>();
      for (Daily daily : dailyDinner) {
        dinner.add(dishService.selectById(daily.getDish()));
      }
      allDinner.add(dinner);
      cal.add(Calendar.DATE, 1);
    }
    model.addAttribute("breakfast", allBreakfast);
    model.addAttribute("lunch", allLunch);
    model.addAttribute("dinner", allDinner);
    model.addAttribute("dateList", dateList);
    model.addAttribute("date", new Date());
    model.addAttribute("dateStart", dateStart);
    model.addAttribute("dateEnd", dateEnd);

    return "date";
  }

  /*
  TODO: 添加一下日期范围内的增加菜谱
   其实我有个想法，我在把每天的单一分类全加起来生成一个足够长的array，这个array要保证是唯一元素的，再每天分配，
   在分配前要打乱顺序！
   */
  @RequestMapping("/randomBetweenTwoDates")
  public String randomBetweenTwoDates(String dateStart, String dateEnd, int cycle,
      int breakfastMeat, int breakfastVegetable, int breakfastMixed,
      int lunchMeat, int lunchVegetable, int lunchMixed,
      int dinnerMeat, int dinnerVegetable, int dinnerMixed,
      String url
  ) {


    return "redirect:/" + url;
  }



}
