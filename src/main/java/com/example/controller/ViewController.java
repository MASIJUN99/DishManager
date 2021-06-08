package com.example.controller;

import com.example.pojo.Daily;
import com.example.pojo.Dish;
import com.example.service.DailyService;
import com.example.service.DishService;
import com.example.service.RecipeService;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyDateUtils;
import com.example.utils.MyStringToDateConverter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

  @Autowired
  DishService dishService;
  @Autowired
  RecipeService recipeService;
  @Autowired
  DailyService dailyService;
  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();
  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();
  MyDateUtils myDateUtils = new MyDateUtils();

  @RequestMapping({"/", "index", "index.html"})
  public String toIndex(Model model) {

    Date date = new Date(System.currentTimeMillis());
//    Date date = myStringToDateConverter.convert("2021-5-28");
    String dateStr = myDateToStringConverter.convert(date);
    model.addAttribute("date", dateStr);  // 把时间放进去

    // 按顿查好
    List<Daily> dailiesBreakfast = dailyService.selectByDateAndTime(date, Daily.BREAKFAST);
    List<Daily> dailiesLunch     = dailyService.selectByDateAndTime(date, Daily.LUNCH);
    List<Daily> dailiesDinner    = dailyService.selectByDateAndTime(date, Daily.DINNER);

    // 按顿查好，并放入dish
    List<Dish> dishesBreakfast = new ArrayList<>();
    List<Dish> dishesLunch     = new ArrayList<>();
    List<Dish> dishesDinner    = new ArrayList<>();
    for (Daily daily : dailiesBreakfast) {
      dishesBreakfast.add(dishService.selectById(daily.getDish()));
    }
    for (Daily daily : dailiesLunch) {
      dishesLunch.add(dishService.selectById(daily.getDish()));
    }
    for (Daily daily : dailiesDinner) {
      dishesDinner.add(dishService.selectById(daily.getDish()));
    }

    dishesBreakfast.sort((x, y) -> Integer.compare(x.getCategory(), y.getCategory()));
    dishesLunch.sort((x, y) -> Integer.compare(x.getCategory(), y.getCategory()));
    dishesDinner.sort((x, y) -> Integer.compare(x.getCategory(), y.getCategory()));

    // 放到请求体
    String url = "index";  // 保存跳转页面

    model.addAttribute("url", url);
    model.addAttribute("breakfast", dishesBreakfast);
    model.addAttribute("lunch", dishesLunch);
    model.addAttribute("dinner", dishesDinner);
    model.addAttribute("dishes", dishService.selectAll());

    return url;
  }

  @RequestMapping("/week")
  public String toWeek(Model model) {
    Date date = new Date();
    String dateStr = myDateToStringConverter.convert(date);
    model.addAttribute("date", dateStr);
    return "week";
  }

  @RequestMapping("/dateRange")
  public String dateRange(Model model) {
    Date date = new Date();
    String dateStr = myDateToStringConverter.convert(date);
    model.addAttribute("date", dateStr);
//    return "redirect:/queryBetweenTwoDates?dateStart=" + dateStr + "&dateEnd=" + dateStr;
    return "date";

  }







}
