package com.codedifferently.lesson12.factory.kevinmason;

import com.codedifferently.lesson12.library.Book;
import com.codedifferently.lesson12.library.MediaItem;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.util.ArrayList;
import java.util.List;

public class CsvDataLoader {

  // Method to load data for various media items
  public List<MediaItem> loadData(List<MediaItemModel> items) {
    List<MediaItem> results = new ArrayList<>();
    for (MediaItemModel item : items) {
      switch (item.type) {
        case "book" -> {
          List<String> authors = item.authors; // Extract authors from the MediaItemModel
          int numberOfPages = item.pages; // Extract number of pages from the MediaItemModel

          // Create a new Book object and add it to the results list
          results.add(new Book(item.title, item.isbn, Double.parseDouble(item.additionalData)));
        }
          // Handle other media types similarly
          // case "dvd" -> { /* Handle DVDs */ }
          // case "magazine" -> { /* Handle magazines */ }
          // case "newspaper" -> { /* Handle newspapers */ }
          // Add more cases for other media types as needed
      }
    }
    return results;
  }
}
