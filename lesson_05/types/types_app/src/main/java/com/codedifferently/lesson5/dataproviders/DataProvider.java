package com.codedifferently.lesson5.dataprovider;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is a base class for data providers. It provides a method for parsing data from a list
 * of maps.
 */
public abstract class DataProvider {
  public abstract String getProviderName();

  public abstract Map<String, Class> getColumnTypeByName();

  public List<Map<String, Object>> parseData(List<Map<String, String>> data) throws IOException {
    Map<String, Class> columnTypeByName = getColumnTypeByName();
    return data.stream().map(row -> parseRow(columnTypeByName, row)).collect(Collectors.toList());
  }

  private Map<String, Object> parseRow(
      Map<String, Class> columnTypeByName, Map<String, String> row) {
    var parsedRow = new java.util.HashMap<String, Object>();
    row.forEach(
        (key, value) -> {
          Class type = columnTypeByName.get(key);
          try {
            parsedRow.put(key, type.getConstructor(String.class).newInstance(value));
          } catch (Exception e) {
            throw new RuntimeException(
                "Error parsing data for " + key + " as type " + type.getName());
          }
        });
    return parsedRow;
  }
}
