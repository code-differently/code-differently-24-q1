package main.java.com.codedifferently.lesson12.factory.kyvonthompson;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class CsvDataLoader implements LibraryCsvDataLoader {

  @Override
  public LibraryDataModel loadData() {
    LibraryDataModel libraryDataModel = new LibraryDataModel(); // Initialize libraryDataModel
    libraryDataModel.mediaItems = readMediaItemsFromCsv("csv/media_items.csv");
    libraryDataModel.guests = readGuestsFromCsv("csv/guests.csv");
    populateGuestsWithCheckouts("csv/checked_out_items.csv", libraryDataModel.guests);
    return libraryDataModel;
  }

  private List<MediaItemModel> readMediaItemsFromCsv(String filePath) {
    List<MediaItemModel> items = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(",");
        MediaItemModel item = new MediaItemModel();
        item.type = parts[0];
        item.id = UUID.fromString(parts[1]);
        item.title = parts[2];
        item.isbn = parts[3];
        item.authors = List.of(parts[4].split("\\s*,\\s*"));
        item.pages = parts[5].isEmpty() ? 0 : Integer.parseInt(parts[5]);
        item.runtime = parts[6].isEmpty() ? 0 : Integer.parseInt(parts[6]);
        item.edition = parts[7];
        items.add(item);
      }
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items from file: " + filePath, e);
    }
    return items;
  }

  private List<LibraryGuestModel> readGuestsFromCsv(String filePath)
      throws IOException, CsvValidationException {
    List<LibraryGuestModel> guests = new ArrayList<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      reader.skip(1); // Skip header
      String[] line;
      while ((line = reader.readNext()) != null) {
        LibraryGuestModel guest = new LibraryGuestModel();
        guest.type = line[0];
        guest.name = line[1];
        guest.email = line[2];
        guests.add(guest);
      }
    }
    return guests;
  }

  private void populateGuestsWithCheckouts(String filePath, List<LibraryGuestModel> guests)
      throws IOException, CsvValidationException {
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      reader.skip(1); // Skip header
      String[] line;
      while ((line = reader.readNext()) != null) {
        String email = line[0];
        CheckoutModel checkout = new CheckoutModel();
        checkout.itemId = UUID.fromString(line[1]);
        checkout.dueDate = Instant.parse(line[2]);
        checkoutsByGuestEmail.computeIfAbsent(email, k -> new ArrayList<>()).add(checkout);
      }
    }
    // Assign checked-out items to respective guests
    for (LibraryGuestModel guest : guests) {
      List<CheckoutModel> checkouts =
          checkoutsByGuestEmail.getOrDefault(guest.email, new ArrayList<>());
      guest.checkedOutItems = checkouts;
    }
  }
}
