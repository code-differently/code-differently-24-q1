package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class RandyCastroProvider extends DataProvider {
  public String getProviderName() {
    return "RandyCastroProvider";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Short.class,
        "column2", Long.class,
        "column3", String.class,
        "column4", Boolean.class,
        "column5", Float.class,
        "column6", Integer.class,
        "column7", Double.class);
  }
}
