package com.codedifferently.lesson9.JadasLibrary;

import java.util.List;

public interface Patron {

  void checkOutBook(Book book);

  void returnBook(Book book);

  List<Book> getCheckedOutBooks();

  String getName();
}
