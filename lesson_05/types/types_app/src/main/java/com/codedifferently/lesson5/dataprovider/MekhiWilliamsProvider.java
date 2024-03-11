package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MekhiWilliamsProvider extends DataProvider {
  public String getProviderName() {
    return "mekhiwilliams";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", String.class,
        "column3", Float.class,
        "column4", Double.class,
        "column5", Boolean.class,
        "column6", Integer.class,
        "column7", Short.class);
  }
}
