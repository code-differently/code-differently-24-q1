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
        "column1", Integer.class,
        "column2", Boolean.class,
        "column3", Short.class,
        "column4", String.class,
        "column5", Float.class,
        "column6", Long.class,
        "column7", Double.class);
  }
}
