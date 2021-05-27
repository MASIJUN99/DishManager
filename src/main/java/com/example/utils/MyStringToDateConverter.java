package com.example.utils;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.core.convert.converter.Converter;

public class MyStringToDateConverter implements Converter<String, Date> {

  @Override
  public Date convert(String s) {
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = (Date) df.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }
}
