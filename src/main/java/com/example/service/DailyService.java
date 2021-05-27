package com.example.service;

import com.example.mapper.DailyMapper;
import com.example.mapper.DishMapper;
import com.example.pojo.Daily;
import com.example.pojo.Dish;
import com.example.utils.ArraysUtils;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyStringToDateConverter;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyService {

  @Autowired
  DailyMapper dailyMapper;
  @Autowired
  DishMapper dishMapper;
  @Autowired
  ArraysUtils arrayUtils;

  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();
  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();

  public List<Daily> selectAll() {
    return dailyMapper.selectAll();
  }

  public List<Daily> selectByDish(Integer dish) {
    return dailyMapper.selectByDish(dish);
  }

  public List<Daily> selectByDate(Date date) {
    String convert = myDateToStringConverter.convert(date);
    return dailyMapper.selectByDate(convert);
  }

  public List<Daily> selectByTime(Integer time) {
    return dailyMapper.selectByTime(time);
  }

  public List<Daily> selectByDateAndTime(Date date, Integer time) {
//    List<Daily> array1 = selectByDate(date);
//    List<Daily> array2 = selectByTime(time);
//    return arrayUtils.retainAll(array1, array2);
    String convert = myDateToStringConverter.convert(date);
    return dailyMapper.selectByDateAndTime(convert, time);
  }

  public Daily selectByDishIdInDateAndTime(int dishId, String date, int time) {
    List<Daily> dailies = dailyMapper.selectByDishIdInDateAndTime(dishId, date, time);
    return dailies.get(0);
  }

  public int insert(Daily daily) {
    return dailyMapper.insert(daily);
  }

  /**
   * 根据输入的dish获得数据库中dish的id（根据dish.name）
   * 新建Daily对象，放入date和time放入数据库
   * 实际上就是dish是dish的外键
   */
  public int insertByDateAndDish(String date,Integer time, Dish dish) {
    dish = dishMapper.selectByName(dish.getName());
    Daily daily = new Daily(-1, dish.getId(), date, time);
    return dailyMapper.insert(daily);
  }

  public int insertDishInDateAndTime(String date, int time, int dishId) {
    Daily daily = new Daily(date, time, dishId);
    return dailyMapper.insert(daily);
  }

  /**
   * 重载，如果上面的情况是List
   */
  public int insertByDateAndDish(String date,Integer time, List<Dish> dishes) {
    int result = -1;
    for (Dish dish : dishes) {
      result = insertByDateAndDish(date, time ,dish);
      if (result == -1) {
        return result;
      }
    }
    return result;
  }

  public int updateById(Daily daily) {
    return dailyMapper.updateById(daily);
  }

  public int deleteById(int id) {
    return dailyMapper.deleteById(id);
  }





}
