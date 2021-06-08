package com.example;

import com.example.pojo.Daily;
import com.example.service.DailyService;
import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyDateUtils;
import com.example.utils.MyStringToDateConverter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeekTest {

  @Autowired
  DailyService dailyService;

  MyDateToStringConverter myDateToStringConverter = new MyDateToStringConverter();
  MyStringToDateConverter myStringToDateConverter = new MyStringToDateConverter();


  @Test
  void testWeek() {

    MyStringToDateConverter converter = new MyStringToDateConverter();
    Date date = converter.convert("2021-5-13");

    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);

    int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
    week = week == 0 ? 7 : week;
    System.out.println(week);

    List<String> dateList = new ArrayList<>();
    calendar.add(Calendar.DATE, -week);
    for (int i = 0; i < 7; i++) {
      calendar.add(Calendar.DATE, 1);
      Date time = calendar.getTime();
      dateList.add(myDateToStringConverter.convert(time));
    }
    System.out.println(dateList);

//    String out = null;
//    switch(week){
//      case 1: out = "星期一"; break;
//      case 2: out = "星期二"; break;
//      case 3: out = "星期三"; break;
//      case 4: out = "星期四"; break;
//      case 5: out = "星期五"; break;
//      case 6: out = "星期六"; break;
//      case 7: out = "星期日"; break;
//    }
//    System.out.println(out);
  }

  @Test
  void testNextDay() {
    Date date = myStringToDateConverter.convert("2021-5-25");
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);


    calendar.add(Calendar.DATE, 1);
    Date time = calendar.getTime();
    String convert = myDateToStringConverter.convert(time);
    System.out.println(convert);

  }

  @Test
  void testBefore() {
    Calendar cal = Calendar.getInstance();
    cal.setTime(new Date());
    Calendar stop = Calendar.getInstance();
    stop.setTime(myStringToDateConverter.convert("2021-6-4"));
    while (cal.before(stop)) {
      System.out.println(myDateToStringConverter.convert(cal.getTime()));
      cal.add(Calendar.DATE,1);
    }
    System.out.println(cal.before(stop));
  }

  @Test
  void testNearlyDish() {
    List<Daily> dailies = dailyService.selectByDate("2021-05-28");
    System.out.println(dailies);
//    MyDateUtils myDateUtils = new MyDateUtils();
//    myDateUtils.getNearlyDish(3, "2021-5-31");
  }

  @Test
  void testInteger() {
    Integer integer = 1;
    Integer integer1 = 1;
    System.out.println(integer.equals(integer1));

    Integer integer2 = 200;
    Integer integer3 = 200;
    System.out.println(integer3.equals(integer2));
  }

}
