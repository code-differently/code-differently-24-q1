package com.codedifferently.lesson12.factory.kevinmason;

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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service
public class CsvDataLoader implements LibraryCsvDataLoader {
  public static void main(String[] args) throws IOException {
    new CsvDataLoader().loadData();
  }

  @Override
  public LibraryDataModel loadData() throws IOException {
    LibraryDataModel libraryData = new LibraryDataModel();

    libraryData.guests = readGuestList("csv/guests.csv");
    libraryData.mediaItems = readMediaItems("csv/media_items.csv");
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail =
        readCheckedOutByEmail("csv/checked_out_items.csv");

    for (LibraryGuestModel guest : libraryData.guests) {
      List<CheckoutModel> checkouts = checkoutsByGuestEmail.get(guest.email);
      if (checkouts != null) {
        guest.checkedOutItems = checkouts;
      } else {
        guest.checkedOutItems = new ArrayList<>();
      }
    }

    return libraryData;
  }

  public static List<MediaItemModel> readMediaItems(String path) {
    try (BufferedReader reader =
        new BufferedReader(new FileReader(new ClassPathResource(path).getFile()))) {
      List<MediaItemModel> items = new ArrayList<>();
      String line;
      // Skip headers
      reader.readLine();
      for (line = reader.readLine(); line != null; line = reader.readLine()) {
        String[] parts = line.split(",", 8);
        MediaItemModel item = new MediaItemModel();
        item.type = parts[0];
        item.id = UUID.fromString(parts[1]);
        item.title = parts[2];
        item.isbn = parts[3];
        item.authors = List.of(parts[4]);

        if (parts[5].equals("")) {
          item.pages = 0;
        } else {
          item.pages = Integer.parseInt(parts[5]);
        }

        if (parts[6].equals("")) {
          item.runtime = 0;
        } else {
          item.runtime = Integer.parseInt(parts[6]);
        }
        item.edition = parts[7];

        items.add(item);
      }
      return items;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }

  private List<LibraryGuestModel> readGuestList(String path) {
    try (BufferedReader reader =
        new BufferedReader(new FileReader(new ClassPathResource(path).getFile()))) {
      List<LibraryGuestModel> guests = new ArrayList<>();
      String line;
      // Skip headers
      reader.readLine();
      for (line = reader.readLine(); line != null; line = reader.readLine()) {
        String[] parts = line.split(",");
        LibraryGuestModel guest = new LibraryGuestModel();
        guest.type = parts[0];
        guest.name = parts[1];
        guest.email = parts[2];
        guests.add(guest);
      }
      return guests;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }

  private static Map<String, List<CheckoutModel>> readCheckedOutByEmail(String path) {
    try (BufferedReader reader =
        new BufferedReader(new FileReader(new ClassPathResource(path).getFile()))) {
      Map<String, List<CheckoutModel>> checkedOutItems = new HashMap<>();
      String line;
      // Skip headers
      reader.readLine();
      for (line = reader.readLine(); line != null; line = reader.readLine()) {
        String[] parts = line.split(",");
        CheckoutModel item = new CheckoutModel();
        item.itemId = UUID.fromString(parts[1]);
        item.dueDate = Instant.parse(parts[2]);
        if (checkedOutItems.containsKey(parts[0])) {
          checkedOutItems.get(parts[0]).add(item);
        } else {
          List<CheckoutModel> checkOut = new ArrayList<>();
          checkOut.add(item);
          checkedOutItems.put(parts[0], checkOut);
        }
      }
      return checkedOutItems;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }
}
