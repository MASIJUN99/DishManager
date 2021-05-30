package com.example.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MyDateUtils {

  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();
  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();

  public String getWeek(String dateStr) {

    Date date = myStringToDateConverter.convert(dateStr);

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    String out = null;
    switch(week){
      case 0: out = "星期天"; break;
      case 1: out = "星期一"; break;
      case 2: out = "星期二"; break;
      case 3: out = "星期三"; break;
      case 4: out = "星期四"; break;
      case 5: out = "星期五"; break;
      case 6: out = "星期六"; break;
    }
    return out;
  }

  public String getWeek(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    int week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
    String out = null;
    switch(week){
      case 0: out = "星期天"; break;
      case 1: out = "星期一"; break;
      case 2: out = "星期二"; break;
      case 3: out = "星期三"; break;
      case 4: out = "星期四"; break;
      case 5: out = "星期五"; break;
      case 6: out = "星期六"; break;
    }
    return out;
  }

  /**
   * 输入日期获得本周所有日子
   * @param date 输入日期
   * @return 本周所有日期
   */
  public List<String> getWeekList(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    // 获取数字周
    int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
    // 转换周天
    week = week == 0 ? 7 : week;

    List<String> dateList = new ArrayList<>();
    calendar.add(Calendar.DATE, -week);
    for (int i = 0; i < 7; i++) {
      calendar.add(Calendar.DATE, 1);
      Date time = calendar.getTime();
      dateList.add(myDateToStringConverter.convert(time));
    }
    return dateList;
  }

  /**
   * 输入日期获得本周所有日子，重载版，防止日期格式错误
   * @param dateStr 输入日期
   * @return 本周所有日期
   */
  public List<String> getWeekList(String dateStr) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(myStringToDateConverter.convert(dateStr));
    // 获取数字周
    int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
    // 转换周天
    week = week == 0 ? 7 : week;

    List<String> dateList = new ArrayList<>();
    calendar.add(Calendar.DATE, -week);
    for (int i = 0; i < 7; i++) {
      calendar.add(Calendar.DATE, 1);
      Date time = calendar.getTime();
      dateList.add(myDateToStringConverter.convert(time));
    }
    return dateList;
  }

}
