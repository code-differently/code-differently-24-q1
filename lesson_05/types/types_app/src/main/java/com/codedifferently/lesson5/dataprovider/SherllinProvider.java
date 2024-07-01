package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class SherllinProvider extends DataProvider {
  public String getProviderName() {
    return "sherllin";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", Float.class,
        "column3", Boolean.class,
        "column4", String.class,
        "column5", Short.class,
        "column6", Double.class,
        "column7", Integer.class);
  }
}
