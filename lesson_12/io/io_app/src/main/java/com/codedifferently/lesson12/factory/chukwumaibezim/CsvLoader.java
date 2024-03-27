package com.codedifferently.lesson12.factory.mohamedibrahim;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CsvLoader implements LibraryCsvDataLoader {

  @Override
  public LibraryDataModel loadData() throws IOException {
    LibraryDataModel libraryData = new LibraryDataModel();

    libraryData.guests = readGuestList("csv/guests.csv");
    libraryData.mediaItems = readMediaItems("csv/media_items.csv");
    libraryData.checkedOutItems = readCheckedOutByEmail("csv/checked_out_items.csv");

    // Gives each guest a list of their checked out books.
    libraryData.guests.forEach(
        guest ->
            guest.checkedOutItems =
                libraryData.checkedOutItems.getOrDefault(guest.email, new ArrayList<>()));

    return libraryData;
  }

  private List<MediaItemModel> readMediaItems(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      return reader
          .lines()
          .skip(1)
          .map(
              line -> {
                String[] parts = line.split(",", 8);
                MediaItemModel item = new MediaItemModel();
                item.type = parts[0];
                item.id = UUID.fromString(parts[1]);
                item.title = parts[2];
                item.isbn = parts[3];
                item.authors = List.of(parts[4]);
                item.pages = parts[5].isEmpty() ? 0 : Integer.parseInt(parts[5]);
                item.runtime = parts[6].isEmpty() ? 0 : Integer.parseInt(parts[6]);
                item.edition = parts[7];
                return item;
              })
          .collect(Collectors.toList());
    }
  }

  private List<LibraryGuestModel> readGuestList(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      return reader
          .lines()
          .skip(1)
          .map(
              line -> {
                String[] parts = line.split(",");
                LibraryGuestModel guest = new LibraryGuestModel();
                guest.type = parts[0];
                guest.name = parts[1];
                guest.email = parts[2];
                return guest;
              })
          .collect(Collectors.toList());
    }
  }

  private Map<String, List<CheckoutModel>> readCheckedOutByEmail(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      return reader
          .lines()
          .skip(1)
          .map(
              line -> {
                String[] parts = line.split(",");
                CheckoutModel item = new CheckoutModel();
                item.itemId = UUID.fromString(parts[1]);
                item.dueDate = Instant.parse(parts[2]);
                return Map.entry(parts[0], item);
              })
          .collect(
              Collectors.groupingBy(
                  Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }
  }
}
