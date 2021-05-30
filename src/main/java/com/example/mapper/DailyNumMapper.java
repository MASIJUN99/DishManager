package com.example.mapper;

import com.example.pojo.DailyNum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DailyNumMapper {

  DailyNum selectByDate(String date);
  DailyNum selectById(int id);

  int updateById(DailyNum dailyNum);

  int insert(DailyNum dailyNum);

  int deleteByDate(String date);
}
