package com.codedifferently.lesson12.factory.natayaprice;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
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
    var model = new LibraryDataModel();
    model.mediaItems = new ArrayList<>();
    model.guests = new ArrayList<>();

    try {
      List<MediaItemModel> mediaItems =
          readMediaItemsFromCsv(
              "/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/media_items.csv");
    } catch (IOException ex) {
    } catch (CsvValidationException ex) {
    }
    List<LibraryGuestModel> guests =
        readGuests(
            "/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/guests.csv");
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail =
        readCheckoutsByGuestEmail(
            "/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/checked_out_items.csv");

    // STEP 2: Combine checkouts with guests.
    for (var guest : guests) {
      var checkouts = checkoutsByGuestEmail.get(guest.email);
      if (checkouts != null) {
        guest.checkedOutItems = checkouts;
      }
    }

    return model;
  }

  private List<MediaItemModel> readMediaItemsFromCsv(String filePath)
      throws IOException, CsvValidationException {
    List<MediaItemModel> mediaItems = new ArrayList<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      reader.skip(1); // Skip header
      String[] line;
      while ((line = reader.readNext()) != null) {
        MediaItemModel mediaItem = new MediaItemModel();
        mediaItem.type = line[0];
        mediaItem.id = UUID.fromString(line[1]);
        mediaItem.title = line[2];
        mediaItem.isbn = line[3];
        mediaItem.authors = List.of(line[4].split("\\s*,\\s*"));
        mediaItem.pages = line[5].isEmpty() ? 0 : Integer.parseInt(line[5]);
        mediaItem.runtime = line[6].isEmpty() ? 0 : Integer.parseInt(line[6]);
        mediaItem.edition = line[7];
        mediaItems.add(mediaItem);
      }
    }
    return mediaItems;
  }

  private static int parseInteger(String value) {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      // If parsing fails, return 0 as default or handle the error as needed
      return 0;
    }
  }

  private static List<LibraryGuestModel> readGuests(String filePath) {
    try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
      List<LibraryGuestModel> guests = new ArrayList<>();
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        // Assuming each line has at least two fields (name and email)
        if (nextLine.length >= 2) {
          LibraryGuestModel guest = new LibraryGuestModel();
          guest.name = nextLine[0].trim();
          guest.email = nextLine[1].trim();
          guests.add(guest);
        }
      }
      return guests;
    } catch (IOException | CsvValidationException e) {
      throw new RuntimeException("Failed to read guests", e);
    }
  }

  public Map<String, List<CheckoutModel>> readCheckoutsByGuestEmail(String filePath) {
    try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
      Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();
      String[] nextLine;
      while ((nextLine = reader.readNext()) != null) {
        if (nextLine.length < 2) {
          System.err.println("Skipping line due to missing fields: " + String.join(",", nextLine));
          continue;
        }
        String guestEmail = nextLine[0];
        String checkoutData = nextLine[1];
        CheckoutModel checkoutModel = new CheckoutModel(); // You need to initialize this properly
        List<CheckoutModel> checkouts =
            checkoutsByGuestEmail.computeIfAbsent(guestEmail, k -> new ArrayList<>());
        checkouts.add(checkoutModel);
        checkoutsByGuestEmail.put(guestEmail, checkouts);
      }
      return checkoutsByGuestEmail;
    } catch (IOException | CsvValidationException e) {
      throw new RuntimeException("Failed to read checkout data", e);
    }
  }
}
