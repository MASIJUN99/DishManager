package com.example.utils;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.springframework.core.convert.converter.Converter;

public class MyDateToStringConverter implements Converter<Date, String> {

  @Override
  public String convert(Date date) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    String s = df.format(date);
    return s;
  }
}
