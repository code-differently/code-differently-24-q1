package com.codedifferently.lesson5.parser;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnthonyMaysParser {

  public String getProviderName() {
    return "anthonymays";
  }

  public Map<String, Class> getColumnTypeByName() {
    return Map.of(
        "column1", Boolean.class,
        "column2", Integer.class,
        "column3", Long.class,
        "column4", Short.class,
        "column5", String.class,
        "column6", Integer.class,
        "column7", Float.class);
  }

  public List<Map<String, Object>> getParsedData() {
    List<Map<String, String>> data = getData();
    return data.stream()
        .map(
            row -> {
              var parsedRow = new java.util.HashMap<String, Object>();
              var columnTypeByName = getColumnTypeByName();
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
            })
        .collect(Collectors.toList());
  }

  public List<Map<String, String>> getData() {
    String[] pathParts = {
      Paths.get("").toAbsolutePath().toString(), "src", "main", "resources", "data"
    };
    String path = String.join(File.separator, pathParts);
    String fileName = String.join(File.separator, path, getProviderName() + ".json");
    var filePath = Paths.get(fileName);

    try (var reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
      var gson = new Gson();
      var typeToken = new TypeToken<List<Map<String, String>>>() {}.getType();
      return gson.fromJson(reader, typeToken);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }
}
