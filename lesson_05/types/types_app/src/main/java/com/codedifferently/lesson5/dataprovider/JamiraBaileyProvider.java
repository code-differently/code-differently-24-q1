package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JamiraBaileyProvider extends DataProvider {
  public String getProviderName() {
    return "jamirabailey";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Float.class,
        "column2", Double.class,
        "column3", Integer.class,
        "column4", Boolean.class,
        "column5", String.class,
        "column6", Long.class,
        "column7", Short.class);
  }
}
