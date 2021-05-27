package com.example.utils;

import java.util.Calendar;
import java.util.Date;

public class MyDateUtils {

  public String getWeek(String dateStr) {
    MyStringToDateConverter converter = new MyStringToDateConverter();
    Date date = converter.convert(dateStr);

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

}
