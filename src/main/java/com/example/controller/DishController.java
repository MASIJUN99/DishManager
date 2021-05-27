package com.example.controller;

import com.example.pojo.*;
import com.example.service.DailyService;
import com.example.service.DishService;
import com.example.service.RecipeService;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyDateUtils;
import com.example.utils.MyStringToDateConverter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DishController {

  @Autowired
  DishService dishService;
  @Autowired
  RecipeService recipeService;
  @Autowired
  DailyService dailyService;
  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();
  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();
  MyDateUtils myDateUtils = new MyDateUtils();

  @RequestMapping("/allDishes")
  public String allDishes(Model model) {
    List<Dish> dishes = dishService.selectAll();
    model.addAttribute("dishes", dishes);
    return "dish/all";
  }

  @PostMapping("/addDish")
  public String addDish(Dish dish, Recipe recipe, Model model) {
    if (dishService.selectByName(dish.getName()) != null) {
      System.out.println("已存在");
      model.addAttribute("msg", "已存在");
      return "dish/view";
    } else {
      Integer recipeId = recipeService.getNewId();
      dish.setRecipe(recipeId);
      dishService.insert(dish);
      recipeService.insert(recipe);
      return "redirect:/allDishes";
    }
  }

  @GetMapping("/detailDish/{id}")
  public String detailDish(@PathVariable("id") int id, Model model) {
    Dish dish = dishService.selectById(id);
    model.addAttribute("dish", dish);
    return "dish/detail";
  }

  @PostMapping("/updateDish")
  public String updateDish(Dish dish, Model model) {
    dishService.updateById(dish);
    return "redirect:/detailDish/" + dish.getId();
  }

  @PostMapping("/deleteDish")
  public String deleteDish(int id) {
    dishService.deleteById(id);
    return "redirect:/allDishes";
  }




}
