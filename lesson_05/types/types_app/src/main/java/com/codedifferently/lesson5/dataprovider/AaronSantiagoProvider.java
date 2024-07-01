package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AaronSantiagoProvider extends DataProvider {
  public String getProviderName() {
    return "aaronsantiago";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", Short.class,
        "column3", Integer.class,
        "column4", Double.class,
        "column5", Boolean.class,
        "column6", String.class,
        "column7", Float.class);
  }
}
