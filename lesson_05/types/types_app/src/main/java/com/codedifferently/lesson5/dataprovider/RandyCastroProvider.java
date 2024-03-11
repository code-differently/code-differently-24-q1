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

  /*
     "column1": "14780",
   "column2": "489905102837440000",
   "column3": "bmtjv90",
   "column4": "true",
   "column5": "1.0835734E38",
   "column6": "1048333181",
   "column7": "1.317544283408283E308"
  */

   /*       "column1", Short.class,
   "column2", Long.class,
   "column3", String.class,
   "column4", Boolean.class,
   "column5", Float.class,
   "column6", Integer.class,
   "column7", Double.class; */
