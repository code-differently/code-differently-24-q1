package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class NatayaProvider extends DataProvider {
  public String getProviderName() {
    return "NatayaPrice";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Float.class,
        "column2", Boolean.class,
        "column3", Double.class,
        "column4", String.class,
        "column5", Short.class,
        "column6", Long.class,
        "column7", Integer.class);
  }
}
