package com.codedifferently.lesson12.factory;

import com.codedifferently.lesson12.models.LibraryDataModel;
import java.io.IOException;

/** An object that loads data from a CSV and returns a LibraryDataModel object. */
public interface LibraryCsvDataLoader extends LibraryDataLoader {
  @Override
  public LibraryDataModel loadData() throws IOException;
}
