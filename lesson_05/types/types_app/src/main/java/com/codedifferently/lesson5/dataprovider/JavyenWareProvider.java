package com.codedifferently.lesson5.dataprovider;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JavyenWareProvider extends DataProvider {
    public String getProviderName() {
        return "anthonymays";
    }
    public Map<String, Class> getColumnTypeByName() {
        return Map.of(
        "column1", String.class,
        "column2", Integer.class,
        "column3", Float.class,
        "column4", Boolean.class,
        "column5", Double.class,
        "column6", Short.class,
        "column7", Long.class);
    }
}
