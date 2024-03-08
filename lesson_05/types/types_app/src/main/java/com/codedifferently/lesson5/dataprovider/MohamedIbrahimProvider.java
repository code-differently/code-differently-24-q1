package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MohamedIbrahimProvider extends DataProvider {
  public String getProviderName() {
    return "mohamedibrahim";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Double.class,
        "column2", Long.class,
        "column3", Short.class,
        "column4", Integer.class,
        "column5", Float.class,
        "column6", Boolean.class,
        "column7", String.class);
  }
}
