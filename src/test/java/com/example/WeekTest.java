package com.example;

import com.example.utils.MyDateToStringConverter;
import com.example.utils.MyStringToDateConverter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeekTest {

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

}
