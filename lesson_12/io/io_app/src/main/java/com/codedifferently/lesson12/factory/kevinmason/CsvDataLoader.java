package com.codedifferently.lesson12.factory.kevinmason;

import com.codedifferently.lesson12.factory.LibraryDataLoader;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * A concrete implementation of the LibraryDataLoader interface that loads data from CSV files in
 * the app's resources/csv directory.
 */
@Service // Annotation for Spring to recognize this class as a service component
public class CsvDataLoader implements LibraryDataLoader {

  // CSV file path
  private static final String CSV_FILE_PATH = "src/main/resources/csv/data.csv";

  @Override
  public LibraryDataModel loadData() throws IOException {
    LibraryDataModel libraryDataModel = new LibraryDataModel();
    libraryDataModel.mediaItems = loadMediaItemsFromCsv();
    // Load other data if needed
    return libraryDataModel;
  }

  // Method to load media items from CSV
  private List<MediaItemModel> loadMediaItemsFromCsv() throws IOException {
    List<MediaItemModel> mediaItems = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
      String line;
      // Skip header line if present
      br.readLine();
      while ((line = br.readLine()) != null) {
        String[] data = line.split(",");
        MediaItemModel mediaItem = createMediaItemFromCsvData(data);
        mediaItems.add(mediaItem);
      }
    }
    return mediaItems;
  }

  // Method to create a MediaItemModel object from CSV data
  private MediaItemModel createMediaItemFromCsvData(String[] data) {
    MediaItemModel mediaItem = new MediaItemModel();
    mediaItem.type = data[0];
    mediaItem.id = UUID.fromString(data[1]);
    mediaItem.title = data[2];
    mediaItem.isbn = data[3];
    // Set other attributes as needed
    return mediaItem;
  }
}
