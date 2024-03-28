package com.codedifferently.lesson12.factory.vicentevigueras;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * @author vscode
 */
@Service("VicenteLibraryCsvDataLoader")
public class CsvDataLoader implements LibraryCsvDataLoader {

  @Override
  public LibraryDataModel loadData() throws IOException {
    // Create object named model that is an instance of LibraryDataModel
    var model = new LibraryDataModel();
    // Creates a list and loads with everything inside of file path
    model.mediaItems = readMediaItems("csv/media_items.csv");
    model.guests = readGuests("csv/guests.csv");
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail =
        getCheckedOutItems("csv/checked_out_items.csv");
    for (var guest : model.guests) {
      var checkouts = checkoutsByGuestEmail.get(guest.email);
      if (checkouts == null) {
        checkouts = new ArrayList<>();
      }
      guest.checkedOutItems = checkouts;
    }

    return model;
  }

  // Read data after loading it.
  private List<MediaItemModel> readMediaItems(String filePath) throws IOException {
    String[] eachLine = getFileContent(filePath).split("\n");

    var items = new ArrayList<MediaItemModel>();

    for (int i = 1; i < eachLine.length; i++) {
      String[] parts = eachLine[i].split(",", -1);
      var item = new MediaItemModel();

      // Parse as proper data types
      // if else statements to handle empty spots
      item.type = parts[0];
      item.id = UUID.fromString(parts[1]);
      item.title = parts[2];
      if (parts.length > 3) {
        item.isbn = parts[3];
      }
      if (parts.length > 4) {
        item.authors = Arrays.asList(parts[4]);
      }
      if (parts.length > 5) {
        item.pages = Integer.parseInt(parts[5].isEmpty() ? "0" : parts[5]);
      }
      if (parts.length > 6) {
        item.runtime = Integer.parseInt(parts[6].isEmpty() ? "0" : parts[6]);
      }
      if (parts.length > 7) {
        item.edition = parts[7];
      }
      items.add(item);
    }
    return items;
  }

  private List<LibraryGuestModel> readGuests(String filePath) throws IOException {
    String[] eachLine = getFileContent(filePath).split("\n");

    var guests = new ArrayList<LibraryGuestModel>();

    for (int i = 1; i < eachLine.length; i++) {
      String[] parts = eachLine[i].split(",", -1);
      var guest = new LibraryGuestModel();
      guest.type = parts[0];
      guest.name = parts[1];
      guest.email = parts[2];
      guests.add(guest);
    }
    return guests;
  }

  private Map<String, List<CheckoutModel>> getCheckedOutItems(String filePath) throws IOException {
    String fileContent = getFileContent(filePath);

    Map<String, List<CheckoutModel>> checkedOutItems = new HashMap<>();
    String[] eachLine = fileContent.split("\n");

    for (int i = 1; i < eachLine.length; i++) {
      // separate elements
      String[] parts = eachLine[i].split(",", -1);

      // read parts of the line
      String email = parts[0];

      CheckoutModel newCheckoutModel = new CheckoutModel();
      newCheckoutModel.itemId = UUID.fromString(parts[1]);
      newCheckoutModel.dueDate = Instant.parse(parts[2]);

      List<CheckoutModel> existingCheckoutModel = checkedOutItems.get(email);
      // validate there is not checkout items in the map
      if (existingCheckoutModel == null) {
        existingCheckoutModel = new ArrayList<>();
      }
      existingCheckoutModel.add(newCheckoutModel);
      // store full thing in the map
      checkedOutItems.put(email, existingCheckoutModel);
    }

    return checkedOutItems;
  }

  private String getFileContent(String filePath) throws IOException {
    File myResource = new ClassPathResource(filePath).getFile();
    return new String(Files.readAllBytes(myResource.toPath()));
  }
}
