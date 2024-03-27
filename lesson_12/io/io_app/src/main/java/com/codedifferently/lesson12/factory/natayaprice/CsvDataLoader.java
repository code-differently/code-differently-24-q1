package com.codedifferently.lesson12.factory.natayaprice;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CsvDataLoader implements LibraryCsvDataLoader {
  public static void main(String[] args) {
    readMediaItems(
        "/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/java/com/codedifferently/lesson12/models/MediaItemModel.java");
  }

  @Override
  public LibraryDataModel loadData() {
    var model = new LibraryDataModel();
    model.mediaItems = new ArrayList<>();
    model.guests = new ArrayList<>();

    List<MediaItemModel> mediaItems =
        readMediaItems(
            "/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/media_items.csv");
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

  public static List<MediaItemModel> readMediaItems(String string) {
    try (var reader = new BufferedReader(new FileReader(string))) {
      var items = new ArrayList<MediaItemModel>();
      String line;
      while ((line = reader.readLine()) != null) {
        var parts = line.split(",", 8);
        var item = new MediaItemModel();

        if (parts.length >= 4) {
          item.type = parts[0];
          item.id = UUID.fromString(parts[1]);
          item.title = parts[2];
          item.isbn = parts[3];
          item.authors = List.of(parts[4]);
          item.pages = Integer.parseInt(parts[5]);
          item.runtime = Integer.parseInt(parts[6]);
          item.edition = parts[7];
        } else {
          System.err.println("Skipping line due to missing fields: " + line);
          continue;
        }

        // Checks if the index for this variable is empty and sets it to 0.
        if (parts[5].equals("")) item.pages = 0;
        else item.pages = Integer.parseInt(parts[5]);

        if (parts[6].equals("")) item.runtime = 0;
        else item.runtime = Integer.parseInt(parts[6]);
        item.edition = parts[7];

        items.add(item);
      }
      return items;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }

  private List<LibraryGuestModel> readGuests(String filePath) {
    try (var reader = new BufferedReader(new FileReader(filePath))) {
      var guests = new ArrayList<LibraryGuestModel>();
      String line;
      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if (line.isEmpty()) {
          continue;
        }
        var parts = line.split(",");
        var guest = new LibraryGuestModel();

        guest.name = parts[0].trim();
        guest.email = parts[1].trim();

        guests.add(guest);
      }
      return guests;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read guests", e);
    }
  }

  private Map<String, List<CheckoutModel>> readCheckoutsByGuestEmail(String filePath) {
    try (var reader = new BufferedReader(new FileReader(filePath))) {
      Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();
      String line;
      while ((line = reader.readLine()) != null) {

        if (line.trim().isEmpty()) {
          continue;
        }
        var parts = line.split(",");
        var item = new CheckoutModel();
        // item.itemId = UUID.fromString(parts[1]);
        // item.dueDate = Instant.parse(parts[2]);

        if (parts.length < 2) {

          System.err.println("Skipping line due to missing fields: " + line);
          continue;
        }
        String guestEmail = parts[0];
        String checkoutData = parts[1];
        CheckoutModel checkoutModel = new CheckoutModel();
        List<CheckoutModel> checkouts =
            checkoutsByGuestEmail.computeIfAbsent(guestEmail, k -> new ArrayList<>());
        checkouts.add(checkoutModel);
        checkoutsByGuestEmail.put(guestEmail, checkouts);
      }
      return checkoutsByGuestEmail;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read checkout data", e);
    }
  }
}
