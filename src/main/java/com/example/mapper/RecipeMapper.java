package com.example.mapper;

import com.example.pojo.Recipe;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecipeMapper {

  List<Recipe> selectAll();
  Recipe selectById(int id);
  Recipe selectLast();
  Integer selectMaxId();

  int insert(Recipe recipe);

  int deleteAll();
  int deleteById(int id);

}
