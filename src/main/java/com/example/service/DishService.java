package com.example.service;

import com.example.mapper.DailyMapper;
import com.example.mapper.DishMapper;
import com.example.pojo.Dish;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishService {

  @Autowired
  DishMapper dishMapper;
  @Autowired
  DailyMapper dailyMapper;

  public List<Dish> selectAll() {
    return dishMapper.selectAll();
  }

  public Dish selectById(int id) {
    return dishMapper.selectById(id);
  }

  public Dish selectByName(String name) {
    return dishMapper.selectByName(name);
  }

  public List<Dish> selectByCategory(int category) {
    return dishMapper.selectByCategory(category);
  }

  public int insert(Dish dish) {
    if (dishMapper.selectByName(dish.getName()) != null) {
      return -1;
    } else {
      return dishMapper.insert(dish);
    }
  }

  public int updateById(Dish dish) {
    if (dish.getId() == null) {
      return -1;
    } else if (dishMapper.selectById(dish.getId()) == null) {
      return -1;
    } else {
      return dishMapper.updateById(dish);
    }
  }

  public int updateByName(Dish dish) {
    if (dish.getName() == null) {
      return -1;
    } else if (dishMapper.selectByName(dish.getName()) == null) {
      return -1;
    } else {
      return dishMapper.updateByName(dish);
    }
  }

  public int deleteAll() {
    return dishMapper.deleteAll();
  }

  public int deleteById(int id) {
    if (dishMapper.selectById(id) == null) {
      return -1;
    } else {
      return dishMapper.deleteById(id);
    }
  }

  public int deleteByName(String name) {
    if (dishMapper.selectByName(name) == null) {
      return -1;
    } else {
      return dishMapper.deleteByName(name);
    }
  }


}
