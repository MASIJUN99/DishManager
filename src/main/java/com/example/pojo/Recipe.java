package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

  public static String[] ZH_CN_NAME;

  static {
    ZH_CN_NAME = new String[]{
        "猪肉", "牛肉", "羊肉", "鸡肉", "鸭肉", "其他",
    };
  }


  private Integer id      = 0;
  private Double  pork    = 0.0;  // 🐂
  private Double  beef    = 0.0;  // 🐖
  private Double  mutton  = 0.0;  // 🐏
  private Double  chicken = 0.0;  // 🐥
  private Double  duck    = 0.0;  // 🦆
  private Double  others  = 0.0;

  public Recipe(Double pork, Double beef, Double mutton, Double chicken, Double duck,
      Double others) {
    this.pork    = pork;
    this.beef    = beef;
    this.mutton  = mutton;
    this.chicken = chicken;
    this.duck    = duck;
    this.others  = others;
  }

  public void add(Recipe recipe) {
    this.pork    += recipe.getPork();
    this.beef    += recipe.getBeef();
    this.mutton  += recipe.getMutton();
    this.chicken += recipe.getChicken();
    this.duck    += recipe.getDuck();
    this.others  += recipe.getOthers();
  }

  public void mul(int num) {
    this.pork    *= num;
    this.beef    *= num;
    this.mutton  *= num;
    this.chicken *= num;
    this.duck    *= num;
    this.others  *= num;
  }
}