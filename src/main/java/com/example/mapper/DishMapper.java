package com.example.mapper;

import com.example.pojo.Dish;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DishMapper {

  List<Dish> selectAll();
  Dish selectByName(String name);
  Dish selectById(int id);
  List<Dish> selectByCategory(int category);

  int insert(Dish dish);

  int updateById(Dish dish);
  int updateByName(Dish dish);

  int deleteAll();
  int deleteById(int id);
  int deleteByName(String name);


}
