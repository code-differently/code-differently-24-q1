package com.codedifferently.lesson12.factory;

import java.io.IOException;

import com.codedifferently.lesson12.models.LibraryDataModel;

/** An object that loads data from a CSV and returns a LibraryDataModel object. */
public interface LibraryCsvDataLoader extends LibraryDataLoader {
  @Override
  public LibraryDataModel loadData() throws IOException;
}
 