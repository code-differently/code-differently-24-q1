package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class VicenteVigueras extends DataProvider {
  public String getProviderName() {
    return "vicentevigueras";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Double.class, // within 64 bit precision
        "column2", Long.class, // more than 2 billion
        "column3", Integer.class, // within 2 billion
        "column4", Boolean.class, // true vs false
        "column5", Short.class, // within 32,0000 range
        "column6", String.class, // has letters/characters
        "column7", Float.class); // within 32 bit precision
  }
}
