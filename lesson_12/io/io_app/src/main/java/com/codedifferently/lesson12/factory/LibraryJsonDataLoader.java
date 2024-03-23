package com.codedifferently.lesson12.factory;

import com.codedifferently.lesson12.models.LibraryDataModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;

/** Loads data from a JSON file and returns a LibraryDataModel object. */
public class LibraryJsonDataLoader implements LibraryDataLoader {
  @Override
  public LibraryDataModel loadData() throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());

    // Load data from data.json file
    File file = new File(this.getClass().getClassLoader().getResource("json/data.json").getFile());
    return objectMapper.readValue(file, LibraryDataModel.class);
  }
}
