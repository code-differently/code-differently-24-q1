package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class RichHawkins extends DataProvider {
  public String getProviderName() {
    return "richhawkins";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Boolean.class,
        "column2", String.class,
        "column3", Integer.class,
        "column4", Float.class,
        "column5", Short.class,
        "column6", Double.class,
        "column7", Long.class);
  }
}