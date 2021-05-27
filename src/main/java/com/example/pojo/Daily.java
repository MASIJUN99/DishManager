package com.example.pojo;

import com.example.utils.MyDateToStringConverter;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Daily {

  static public int BREAKFAST;
  static public int LUNCH;
  static public int DINNER;

  static {
    BREAKFAST = 1;
    LUNCH = 2;
    DINNER = 3;
  }

  private Integer id;
  private Integer dish;
  private String date;
  private Integer time;

//  public void setDate(Date date) {
//    MyDateToStringConverter converter = new MyDateToStringConverter();
//    this.date = converter.convert(date);
//  }

  public Daily(Integer id, Integer dish, Date date, Integer time) {
    MyDateToStringConverter converter = new MyDateToStringConverter();
    this.id = id;
    this.dish = dish;
    this.date = converter.convert(date);
    this.time = time;
  }

  public Daily(String date, int time, int dishId){
    this.dish = dishId;
    this.date = date;
    this.time = time;
  }
}
