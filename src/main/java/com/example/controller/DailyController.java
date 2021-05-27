package com.example.controller;

import com.example.pojo.Daily;
import com.example.service.DailyService;
import com.example.service.DishService;
import com.example.service.RecipeService;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyDateUtils;
import com.example.utils.MyStringToDateConverter;
import java.util.Date;
import java.util.List;
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
  public String addDish(Integer addDishId, String addDate, Integer addTime) {
    dailyService.insertDishInDateAndTime(addDate, addTime, addDishId);
    return "redirect:/index";
  }

  @RequestMapping("/changeDailyDish")
  public String changeDish(String changeDate, Integer changeTime, Integer oldDishId, Integer changeDishId) {
    System.out.println(changeDate);
    System.out.println(changeTime);
    System.out.println(changeDishId);
    System.out.println(oldDishId);
    Daily daily = dailyService.selectByDishIdInDateAndTime(oldDishId, changeDate, changeTime);
    daily.setDish(changeDishId);
    dailyService.updateById(daily);
    return "redirect:/index";

  }


}
