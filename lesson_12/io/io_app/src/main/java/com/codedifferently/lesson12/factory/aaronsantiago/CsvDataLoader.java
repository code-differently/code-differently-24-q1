package com.codedifferently.lesson12.factory.aaronsantiago;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service("AaronLibraryCsvDataLoader")
public class CsvDataLoader implements LibraryCsvDataLoader {

  @Override
  public LibraryDataModel loadData() {
    LibraryDataModel model = new LibraryDataModel();
    model.mediaItems = readMediaItems("csv/media_items.csv");
    model.guests = readGuests("csv/guests.csv");
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail =
        getCheckedOutItems("csv/checked_out_items.csv");

    // Combine checkouts with guests
    for (LibraryGuestModel guest : model.guests) {
      List<CheckoutModel> checkouts =
          checkoutsByGuestEmail.getOrDefault(guest.email, new ArrayList<>());
      guest.checkedOutItems = checkouts;
    }

    return model;
  }

  private List<MediaItemModel> readMediaItems(String filePath) {
    List<MediaItemModel> items = new ArrayList<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      String[] header = reader.readNext(); // Skip the header
      String[] line;
      while ((line = reader.readNext()) != null) {
        MediaItemModel item = new MediaItemModel();
        item.type = line[0];
        item.id = UUID.fromString(line[1]);
        item.title = line[2];
        item.isbn = line[3];
        item.authors = Arrays.asList(line[4].split("\\s*,\\s*"));
        item.pages = line[5].isEmpty() ? 0 : Integer.parseInt(line[5]);
        item.runtime = line[6].isEmpty() ? 0 : Integer.parseInt(line[6]);
        item.edition = line[7];
        items.add(item);
      }
    } catch (IOException | CsvException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
    return items;
  }

  private List<LibraryGuestModel> readGuests(String filePath) {
    List<LibraryGuestModel> guests = new ArrayList<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      String[] header = reader.readNext(); // Skip the header
      String[] line;
      while ((line = reader.readNext()) != null) {
        LibraryGuestModel guest = new LibraryGuestModel();
        guest.type = line[0];
        guest.name = line[1];
        guest.email = line[2];
        guests.add(guest);
      }
    } catch (IOException | CsvException e) {
      throw new RuntimeException("Failed to read guests", e);
    }
    return guests;
  }

  private Map<String, List<CheckoutModel>> getCheckedOutItems(String filePath) {
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      String[] header = reader.readNext(); // Skip the header
      String[] line;
      while ((line = reader.readNext()) != null) {
        String email = line[0];
        CheckoutModel item = new CheckoutModel();
        item.itemId = UUID.fromString(line[1]);
        item.dueDate = Instant.parse(line[2]);
        checkoutsByGuestEmail.computeIfAbsent(email, k -> new ArrayList<>()).add(item);
      }
    } catch (IOException | CsvException e) {
      throw new RuntimeException("Failed to read checked out items", e);
    }
    return checkoutsByGuestEmail;
  }
}
