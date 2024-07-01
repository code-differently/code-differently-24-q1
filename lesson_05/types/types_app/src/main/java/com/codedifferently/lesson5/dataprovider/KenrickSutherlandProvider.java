package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class KenrickSutherlandProvider extends DataProvider {
  public String getProviderName() {
    return "KenrickSutherland";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", String.class,
        "column2", Double.class,
        "column3", Float.class,
        "column4", Boolean.class,
        "column5", Integer.class,
        "column6", Long.class,
        "column7", Short.class);
  }
}
