package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class KyvonthompsonProvider extends DataProvider {
  public String getProviderName() {
    return "KyvonthompsonProvider";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Double.class,
        "column2", Short.class,
        "column3", Boolean.class,
        "column4", Long.class,
        "column5", Float.class,
        "column6", String.class,
        "column7", Integer.class);
  }
}
