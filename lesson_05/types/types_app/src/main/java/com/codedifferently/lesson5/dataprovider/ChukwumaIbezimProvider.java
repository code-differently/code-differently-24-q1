package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ChukwumaIbezimProvider extends DataProvider {
  public String getProviderName() {
    return "ChukwumaIbezim";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Boolean.class,
        "column2", String.class,
        "column3", Short.class,
        "column4", Double.class,
        "column5", Integer.class,
        "column6", Long.class,
        "column7", Float.class);
  }
}
