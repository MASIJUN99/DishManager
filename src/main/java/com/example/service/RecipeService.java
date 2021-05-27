package com.example.service;

import com.example.mapper.RecipeMapper;
import com.example.pojo.Recipe;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

  @Autowired
  RecipeMapper recipeMapper;

  public List<Recipe> selectAll() {
    return recipeMapper.selectAll();
  }

  public Recipe selectById(int id) {
    return recipeMapper.selectById(id);
  }

  public Recipe selectLast() {
    return recipeMapper.selectLast();
  }

  public Integer selectMaxId() {
    Integer id = recipeMapper.selectMaxId();
    return id == null ? 0 : id;
  }

  public Integer getNewId() {
    Integer id = selectMaxId();
    return id + 1;
  }

  public int insert(Recipe recipe) {
    return recipeMapper.insert(recipe);
  }

  public int deleteAll() {
    return recipeMapper.deleteAll();
  }

  public int deleteById(int id) {
    return recipeMapper.deleteById(id);
  }
}
