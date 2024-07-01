package com.codedifferently.lesson5.dataprovider;

import java.math.BigInteger;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JadaWProvider extends DataProvider {
  public String getProviderName() {
    return "jadawhite";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Integer.class,
        "column2", String.class,
        "column3", Float.class,
        "column4", Boolean.class,
        "column5", Double.class,
        "column6", BigInteger.class,
        "column7", Long.class);
  }
}
