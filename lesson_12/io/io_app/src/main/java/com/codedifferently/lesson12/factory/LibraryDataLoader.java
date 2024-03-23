package com.codedifferently.lesson12.factory;

import com.codedifferently.lesson12.models.LibraryDataModel;
import java.io.IOException;

public interface LibraryDataLoader {
  public LibraryDataModel loadData() throws IOException;
}
