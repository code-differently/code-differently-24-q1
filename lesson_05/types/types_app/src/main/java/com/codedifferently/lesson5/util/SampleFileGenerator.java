package com.codedifferently.lesson5.util;

import com.codedifferently.lesson5.generator.Generators.*;
import com.codedifferently.lesson5.generator.ValueGenerator;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class SampleFileGenerator {

  private static final ValueGenerator[] GENERATORS = {
    new IntValueGenerator(),
    new StringValueGenerator(),
    new DoubleValueGenerator(),
    new ShortValueGenerator(),
    new LongValueGenerator(),
    new FloatValueGenerator()
  };

  public void createTestFile(String path, String providerName) {
    var generators = Arrays.asList(GENERATORS);
    Collections.shuffle(generators);
    var rows = new ArrayList<Map<String, String>>();
    for (var i = 0; i < 10; ++i) {
      var row = new LinkedHashMap<String, String>();
      for (int j = 0; j < generators.size(); ++j) {
        var columnIndex = j + 1;
        row.put("column" + columnIndex, generators.get(j).generateValue());
      }
      rows.add(row);
    }
    var file = new File(path + "/" + providerName + ".json");
    file.getParentFile().mkdirs();
    var gson = new GsonBuilder().setPrettyPrinting().create();
    try (var writer = new FileWriter(file, false)) {
      writer.write(gson.toJson(rows));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
