package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class KevinmasonProvider extends DataProvider {
  public String getProviderName() {
    return "Kevinmason";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", String.class,
        "column2", Double.class,
        "column3", Short.class,
        "column4", Float.class,
        "column5", Long.class,
        "column6", Boolean.class,
        "column7", Integer.class);
  }
}
