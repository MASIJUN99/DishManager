package com.example;

import com.example.pojo.Daily;
import com.example.pojo.Dish;
import com.example.pojo.Recipe;
import com.example.service.DailyService;
import com.example.service.DishService;
import com.example.service.RecipeService;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyStringToDateConverter;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DishManageApplicationTests {

  @Autowired
  DishService dishService;
  @Autowired
  DailyService dailyService;
  @Autowired
  RecipeService recipeService;

  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();
  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();


  @Test
  void testRandom() {
    Random rand = new Random();
    System.out.println(rand.nextDouble() * 3);
  }

  /**
   * 加他妈一百个菜，芽儿哟
   */
  @Test
  void testDish() {
    // 模拟输入
    Random rand = new Random();
    int N = 200;
    for (int i = 0; i < N; i++) {

      String name = "菜品" + i;
      Integer category = rand.nextInt(3); // 用option标签设定value
      Double  pork     = rand.nextDouble() * 2;
      Double  beef     = rand.nextDouble() * 2;
      Double  mutton   = rand.nextDouble() * 2;
      Double  chicken  = rand.nextDouble() * 2;
      Double  duck     = rand.nextDouble() * 2;
      Double  others   = rand.nextDouble() * 2;

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
  }

  @Test
  void del() {
    dishService.deleteAll();
  }

  @Test
  void insertDishTest() {
    Dish dish = new Dish(1000, "菜6", 1, 90);
    dishService.insert(dish);
  }

  @Test
  void insertRecipeTest() {
    Recipe recipe = new Recipe(90, 1.0, 1.0, 1.0, 5.0, 2.0,0.0);
    recipeService.insert(recipe);
  }

  @Test
  void testDate() {
    Date date = new Date(System.currentTimeMillis());
    System.out.println(date);
  }

  @Test
  void testGenDaily() {
    List<Dish> allVegetable = dishService.selectByCategory(0);
    List<Dish> allMeat = dishService.selectByCategory(1);
    List<Dish> allMix = dishService.selectByCategory(2);

    // 定义菜的数量
    int nMeat = 2;
    int nVegetable = 2;
    int nMix = 1;

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
    Date date = new Date(System.currentTimeMillis());

    Integer time = 1; // 午餐
    for (Dish dish : dishes) {
      Integer id = dish.getId();
      Daily daily = new Daily(-1, id, date, time);
      dailyService.insert(daily);
    }
  }

  @Test
  void testDaily() {
    List<Daily> dailies = dailyService.selectByDate(new Date(System.currentTimeMillis()));
    for (Daily daily : dailies) {
      System.out.println("查询到：" + daily);
    }
  }

}
