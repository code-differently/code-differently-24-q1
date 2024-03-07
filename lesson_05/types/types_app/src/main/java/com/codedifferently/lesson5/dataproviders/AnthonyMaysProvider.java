package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AnthonyMaysProvider extends DataProvider {
  public String getProviderName() {
    return "anthonymays";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Boolean.class,
        "column2", Integer.class,
        "column3", Long.class,
        "column4", Short.class,
        "column5", String.class,
        "column6", Double.class,
        "column7", Float.class);
  }
}
