package com.codedifferently.lesson12.factory.mekhiloader;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service("LibraryCsvDataLoader")
public class CsvDataLoader implements LibraryCsvDataLoader {

  private static final int MEDIA_ITEM_FIELDS_COUNT = 8;

  private static final String MEDIA_ITEMS_FILE_PATH = "csv/media_items.csv";
  private static final String GUESTS_FILE_PATH = "csv/guests.csv";
  private static final String CHECKED_OUT_ITEMS_FILE_PATH = "csv/checked_out_items.csv";

  @Override
  public LibraryDataModel loadData() {
    LibraryDataModel libraryData = new LibraryDataModel();

    libraryData.guests = readGuestList(GUESTS_FILE_PATH);
    libraryData.mediaItems = readMediaItems(MEDIA_ITEMS_FILE_PATH);
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail =
        readCheckedOutByEmail(CHECKED_OUT_ITEMS_FILE_PATH);

    for (var guest : libraryData.guests) {
      var checkouts = checkoutsByGuestEmail.getOrDefault(guest.email, Collections.emptyList());
      guest.checkedOutItems = new ArrayList<>(checkouts);
    }

    return libraryData;
  }

  public List<MediaItemModel> readMediaItems(String path) {
    try (var reader = Files.newBufferedReader(Path.of(new ClassPathResource(path).getURI()))) {
      var items = new ArrayList<MediaItemModel>();
      String line;
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        var parts = line.split(",", MEDIA_ITEM_FIELDS_COUNT);
        var item = new MediaItemModel();

        item.type = parts[0];
        item.id = UUID.fromString(parts[1]);
        item.title = parts[2];
        item.isbn = parts[3];
        item.authors = List.of(parts[4]);

        item.pages = parts[5].isEmpty() ? 0 : Integer.parseInt(parts[5]);
        item.runtime = parts[6].isEmpty() ? 0 : Integer.parseInt(parts[6]);
        item.edition = parts[7];

        items.add(item);
      }
      return items;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items from: " + path, e);
    }
  }

  private List<LibraryGuestModel> readGuestList(String path) {
    try (var reader = Files.newBufferedReader(Path.of(new ClassPathResource(path).getURI()))) {
      var guests = new ArrayList<LibraryGuestModel>();
      String line;
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        var parts = line.split(",");
        var guest = new LibraryGuestModel();

        guest.type = parts[0];
        guest.name = parts[1];
        guest.email = parts[2];

        guests.add(guest);
      }
      return guests;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read guest list from: " + path, e);
    }
  }

  private Map<String, List<CheckoutModel>> readCheckedOutByEmail(String path) {
    try (var reader = Files.newBufferedReader(Path.of(new ClassPathResource(path).getURI()))) {
      var checkedOutItems = new HashMap<String, List<CheckoutModel>>();
      String line;
      reader.readLine();
      while ((line = reader.readLine()) != null) {
        var parts = line.split(",");
        var item = new CheckoutModel();

        item.itemId = UUID.fromString(parts[1]);
        item.dueDate = Instant.parse(parts[2]);

        checkedOutItems.computeIfAbsent(parts[0], k -> new ArrayList<>()).add(item);
      }
      return checkedOutItems;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read checked out items from: " + path, e);
    }
  }
}
