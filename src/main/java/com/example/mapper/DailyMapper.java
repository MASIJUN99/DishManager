package com.example.mapper;

import com.example.pojo.Daily;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DailyMapper {

  List<Daily> selectAll();
  List<Daily> selectByDate(String date);
  List<Daily> selectByDish(Integer dish);
  List<Daily> selectByTime(Integer time);
  List<Daily> selectByDateAndTime(String date, Integer time);
  List<Daily> selectByDishIdInDateAndTime(int dishId, String date, int time);

  int insert(Daily daily);

  int updateById(Daily daily);

  int deleteAll();
  int deleteById(int id);
  int deleteByDate(String date);
  int deleteByDateAndTime(String date, int time);




}
