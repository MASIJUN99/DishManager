package com.example.service;

import com.example.mapper.DailyNumMapper;
import com.example.pojo.DailyNum;
import com.example.utils.MyDateToStringConverter;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DailyNumService {

  @Autowired
  DailyNumMapper dailyNumMapper;

  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();

  public DailyNum selectByDate(String date) {
    DailyNum dailyNum = dailyNumMapper.selectByDate(date);
    if (dailyNum == null) {
      dailyNum = new DailyNum(date, 0);
      dailyNumMapper.insert(dailyNum);
    }
    return dailyNum;
  }

  public DailyNum selectByDate(Date date) {
    String dateStr = myDateToStringConverter.convert(date);
    dailyNumMapper.selectByDate(dateStr);
    DailyNum dailyNum = dailyNumMapper.selectByDate(dateStr);
    if (dailyNum == null) {
      dailyNum = new DailyNum(dateStr, 1);
      dailyNumMapper.insert(dailyNum);
    }
    return dailyNum;
  }

  public DailyNum selectById(int id) {
    return dailyNumMapper.selectById(id);
  }

  public int updateById(DailyNum dailyNum) {
    return dailyNumMapper.updateById(dailyNum);
  }

  public int insert(DailyNum dailyNum) {
    return dailyNumMapper.insert(dailyNum);
  }

  public int deleteByDate(String date) {
    return dailyNumMapper.deleteByDate(date);
  }

}
