package com.example;

import com.example.pojo.Daily;
import com.example.pojo.Dish;
import com.example.pojo.Recipe;
import com.example.service.DailyService;
import com.example.service.DishService;
import com.example.service.RecipeService;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyStringToDateConverter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FunctionTest {

  @Autowired
  DishService dishService;
  @Autowired
  DailyService dailyService;
  @Autowired
  RecipeService recipeService;

  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();
  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();


  /**
   * 测试添加菜品
   */
  @Test
  void addDishTest() {
    // 模拟输入
    String name = "菜品x";
    Integer category = 1; // 用option标签设定value
    Double  pork = 1.0;
    Double  beef = 0.0;
    Double  mutton = 1.0;
    Double  chicken = 0.0;
    Double  duck = 1.0;
    Double  others = 1.0;

    // 主逻辑
    if (dishService.selectByName(name) != null) {
      // 模拟输出
      System.out.println("已存在");
    } else {
      Integer recipeId = recipeService.getNewId();
      Dish dish = new Dish(name, category, recipeId);
      dishService.insert(dish);
      Recipe recipe = new Recipe(pork, beef, mutton, chicken, duck, others);
      recipeService.insert(recipe);
    }
  }

  /**
   * 随机生成菜谱，放入List<Dish>
   */
  @Test
  void randomDishesTest() {
    // 模拟输入
    // 定义菜的数量
    int nMeat = 4;
    int nVegetable = 3;
    int nMix = 2;
    Date date = myStringToDateConverter.convert("2021-5-27");
    int time = 1;

    if (dailyService.selectByDateAndTime(date, time) != null) {
      System.out.println("已存在菜谱，重复生成");
    }

    // 获取各分类菜
    List<Dish> allVegetable = dishService.selectByCategory(0);
    List<Dish> allMeat = dishService.selectByCategory(1);
    List<Dish> allMix = dishService.selectByCategory(2);

    // 随机抽菜
    Random rand = new Random();
    List<Dish> dishes = new ArrayList<>();
    for (int i = 0; i < nVegetable; i++) {
      dishes.add(allVegetable.get(rand.nextInt(allVegetable.size())));
    }
    for (int i = 0; i < nMeat; i++) {
      dishes.add(allMeat.get(rand.nextInt(allMeat.size())));
    }
    for (int i = 0; i < nMix; i++) {
      dishes.add(allMix.get(rand.nextInt(allMix.size())));
    }

    // 放入Daily
    for (Dish dish : dishes) {
      Integer id = dish.getId();
      Daily daily = new Daily(-1, id, date, time);
      dailyService.insert(daily);
    }

    // 模拟返回
    List<Daily> dailies = dailyService.selectByDateAndTime(date, time);
    System.out.println(dailies);
  }

  /**
   * 获得某天菜谱
   */
  @Test
  void getDailyByDateTest(){
    // 模拟输入
    Date date = myStringToDateConverter.convert("2021-5-25");

    List<Daily> dailies = dailyService.selectByDate(date);
    List<Dish> dishes = new ArrayList<>();
    for (Daily daily : dailies) {
      dishes.add(dishService.selectById(daily.getDish()));
    }
    System.out.println(dishes);

    List<Recipe> recipes = new ArrayList<>();
    Recipe recipeSum = new Recipe();
    for (Dish dish : dishes) {
      Recipe recipe = recipeService.selectById(dish.getRecipe());
      recipeSum.add(recipe);
    }
    recipeSum.mul(10);
    System.out.println(recipeSum);
  }

  /**
   * 获得某顿菜谱
   */
  @Test
  void getDailyByDateAndTimeTest(){
    // 模拟输入
    Date date = myStringToDateConverter.convert("2021-5-29");
    int time = 2;

    List<Daily> dailies = dailyService.selectByDateAndTime(date, time);

    List<Dish> dishes = new ArrayList<>();
    for (Daily daily : dailies) {
      dishes.add(dishService.selectById(daily.getDish()));
    }
    System.out.println(dishes);

    List<Recipe> recipes = new ArrayList<>();
    Recipe recipeSum = new Recipe();
    for (Dish dish : dishes) {
      Recipe recipe = recipeService.selectById(dish.getRecipe());
      recipeSum.add(recipe);
    }
    recipeSum.mul(10);
    System.out.println(recipeSum);

  }

  /**
   * 生成日期范围内的菜谱
   */
  @Test
  void genWeekMenuTest() {
    Date startDate = myStringToDateConverter.convert("2021-5-24");
    Date endDate   = myStringToDateConverter.convert("2021-5-30");

    Calendar startCal = Calendar.getInstance();
    Calendar endCal = Calendar.getInstance();
    startCal.setTime(startDate);
    endCal.setTime(endDate);

    while (!startCal.after(endCal)) {
      Date date = startCal.getTime();
      String dateStr = myDateToStringConverter.convert(date);

      // TODO: 这里调用生成菜谱的那个玩意

      System.out.println(dateStr);
      startCal.add(Calendar.DATE, 1);
    }



  }



}
