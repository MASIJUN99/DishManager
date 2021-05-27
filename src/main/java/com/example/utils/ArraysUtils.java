package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ArraysUtils<T> {

  public List<T> retainAll(List<T> array1, List<T> array2) {
    List<T> out = new ArrayList<T>();
    for (T a1 : array1) {
      for (T a2 : array2) {
        if (a1 == a2) {
          out.add(a1);
          break;
        }
      }
    }
    return out;
  }

}
