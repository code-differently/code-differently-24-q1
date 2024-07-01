package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JavyenWareProvider extends DataProvider {
  public String getProviderName() {
    return "javyenware";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Long.class,
        "column2", Short.class,
        "column3", Integer.class,
        "column4", Double.class,
        "column5", Float.class,
        "column6", Boolean.class,
        "column7", String.class);
  }
}
