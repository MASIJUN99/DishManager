package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyNum {

  private Integer id;
  private String date;
  private Integer num;

  public DailyNum(String date, Integer num) {
    this.date = date;
    this.num = num;
  }


}
