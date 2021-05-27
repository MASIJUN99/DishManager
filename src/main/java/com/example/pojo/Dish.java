package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {

  private Integer id;
  private String name;
  private Integer category;  // 0素 1荤 2半
  private Integer recipe;

  public Dish(String name, Integer category) {
    // 此处没加recipe
    // 因为recipe的id需要先将recipe放入数据库来获得
    this.name = name;
    this.category = category;
  }

  public Dish(String name, Integer category, Integer recipe) {
    this.name = name;
    this.category = category;
    this.recipe = recipe;
  }
}


