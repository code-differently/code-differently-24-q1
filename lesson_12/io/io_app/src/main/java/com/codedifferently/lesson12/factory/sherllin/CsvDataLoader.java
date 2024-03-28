package com.codedifferently.lesson12.factory.sherllin;

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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

@Service("SherllinLibraryCsvDataLoader")
public class CsvDataLoader implements LibraryCsvDataLoader {

  @Override
  public LibraryDataModel loadData() {
    // Read media items
    List<MediaItemModel> mediaItems = readMediaItems("csv/media_items.csv");

    // Read guests
    List<LibraryGuestModel> guests = readGuests("csv/guests.csv");

    // Read checked-out items
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail =
        readCheckoutItems("csv/checked_out_items.csv");

    for (LibraryGuestModel guest : guests) {
      List<CheckoutModel> checkouts =
          checkoutsByGuestEmail.getOrDefault(guest.email, new ArrayList<>());
      guest.checkedOutItems = checkouts;
    }

    // Construct LibraryDataModel instance with initialized fields
    LibraryDataModel libraryDataModel = new LibraryDataModel();
    libraryDataModel.mediaItems = mediaItems;
    libraryDataModel.guests = guests;

    return libraryDataModel;
  }

  private List<MediaItemModel> readMediaItems(String filePath) {
    try (var reader =
        new BufferedReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      var items = new ArrayList<MediaItemModel>();
      String line;
      boolean isFirstLine = true;
      while ((line = reader.readLine()) != null) {
        if (isFirstLine) {
          isFirstLine = false;
          continue;
        }
        var parts = line.split(",");
        var item = new MediaItemModel();
        item.type = parts[0];
        item.id = UUID.fromString(parts[1]);
        item.title = parts[2];
        item.isbn = parts[3];
        item.authors = Arrays.asList(parts[4].split(","));
        item.pages = parts.length > 5 && !parts[5].isEmpty() ? Integer.parseInt(parts[5]) : 0;
        item.runtime = parts.length > 6 && !parts[6].isEmpty() ? Integer.parseInt(parts[6]) : 0;
        item.edition = parts.length > 7 ? parts[7] : "";
        items.add(item);
      }
      return items;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }

  private List<LibraryGuestModel> readGuests(String filePath) {
    try (var reader =
        new BufferedReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      var items = new ArrayList<LibraryGuestModel>();
      String line;
      boolean isFirstLine = true;
      while ((line = reader.readLine()) != null) {
        if (isFirstLine) {
          isFirstLine = false;
          continue;
        }
        var parts = line.split(",");
        var item = new LibraryGuestModel();
        item.type = parts[0];
        item.name = parts[1];
        item.email = parts[2];
        items.add(item);
      }
      return items;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read guests", e);
    }
  }

  private Map<String, List<CheckoutModel>> readCheckoutItems(String filePath) {
    try (var reader =
        new BufferedReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      var checkoutMap = new HashMap<String, List<CheckoutModel>>();
      String line;
      boolean isFirstLine = true;
      while ((line = reader.readLine()) != null) {
        if (isFirstLine) {
          isFirstLine = false;
          continue;
        }
        var parts = line.split(",");
        var checkoutModel = new CheckoutModel();
        checkoutModel.itemId = UUID.fromString(parts[1]);
        checkoutModel.dueDate = Instant.parse(parts[2]);

        List<CheckoutModel> checkoutModels = checkoutMap.getOrDefault(parts[0], new ArrayList<>());

        checkoutModels.add(checkoutModel);

        checkoutMap.put(parts[0], checkoutModels);
      }
      return checkoutMap;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read checkout items", e);
    }
  }
}
