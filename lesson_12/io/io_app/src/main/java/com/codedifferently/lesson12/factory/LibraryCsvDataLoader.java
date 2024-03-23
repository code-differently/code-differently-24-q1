package com.codedifferently.lesson12.factory;

import com.codedifferently.lesson12.models.LibraryDataModel;
import java.io.IOException;

/** An object that loads data from a CSV and returns a LibraryDataModel object. */
public class LibraryCsvDataLoader implements LibraryDataLoader {
  @Override
  public LibraryDataModel loadData() throws IOException {
    throw new UnsupportedOperationException("Not implemented yet");
  }
}
