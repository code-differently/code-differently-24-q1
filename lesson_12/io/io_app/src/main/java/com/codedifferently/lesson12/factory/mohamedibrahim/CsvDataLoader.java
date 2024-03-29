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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/** LibraryCsvDataLoaderSolid */
@Service("MohamedLibraryCsvDataLoader")
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
    // Gives each guest a list of their checked out books.
    for (var guest : libraryData.guests) {
      var checkouts = checkoutsByGuestEmail.get(guest.email);
      if (checkouts != null) {
        guest.checkedOutItems = checkouts;
      } else {
        guest.checkedOutItems = new ArrayList<>();
      }
    }

    return libraryData;
  }

  /**
   * Gets data from csv file and makes a list of all media items in the library.
   *
   * @param path The file path
   * @return
   */
  public static List<MediaItemModel> readMediaItems(String path) {
    try (var reader = new BufferedReader(new FileReader(new ClassPathResource(path).getFile()))) {
      // The list that will be returned at the end of the function.
      var items = new ArrayList<MediaItemModel>();
      String line;
      // Skips the headers in the csv file.
      line = reader.readLine();
      while ((line = reader.readLine()) != null) {
        // Puts the line read from the csv in an array.
        var parts = line.split(",", 8);
        // Temp item that will latter be added to a list.
        var item = new MediaItemModel();

        // Puts data in the temp item.
        item.type = parts[0];
        item.id = UUID.fromString(parts[1]);
        item.title = parts[2];
        item.isbn = parts[3];
        item.authors = List.of(parts[4]);

        // Checks if the index for this variable is empty and sets it to 0.
        if (parts[5].equals("")) item.pages = 0;
        else item.pages = Integer.parseInt(parts[5]);

        // Checks if the index for this variable is empty and sets it to 0.
        if (parts[6].equals("")) item.runtime = 0;
        else item.runtime = Integer.parseInt(parts[6]);
        item.edition = parts[7];

        items.add(item);
      }
      reader.close();
      return items;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }

  /**
   * Gets data from csv file and makes list of guests in the library.
   *
   * @param path The file path
   * @return
   */
  private List<LibraryGuestModel> readGuestList(String path) {
    try (var reader = new BufferedReader(new FileReader(new ClassPathResource(path).getFile()))) {
      // The list that will be returned at the end of the function.
      var guests = new ArrayList<LibraryGuestModel>();
      String line;
      // Skips the headers in the csv file.
      line = reader.readLine();
      while ((line = reader.readLine()) != null) {
        // Puts the line read from the csv in an array.
        var parts = line.split(",");
        // Temp guest that will latter be added to a list.
        var guest = new LibraryGuestModel();

        // Puts data in the guest item.
        guest.type = parts[0];
        guest.name = parts[1];
        guest.email = parts[2];

        guests.add(guest);
      }
      reader.close();
      return guests;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }

  /**
   * Gets data from csv file and makes a map of items checked out by guest email.
   *
   * @param path The file path.
   * @return
   */
  private static Map<String, List<CheckoutModel>> readCheckedOutByEmail(String path) {
    try (var reader = new BufferedReader(new FileReader(new ClassPathResource(path).getFile()))) {
      // The hashmap that will be returned at the end of the function.
      var checkedOutItems = new HashMap<String, List<CheckoutModel>>();
      String line;
      // Skips the headers in the csv file.
      line = reader.readLine();
      while ((line = reader.readLine()) != null) {
        // Puts the line read from the csv in an array.
        var parts = line.split(",");
        // Temp item that will latter be added to a list.
        var item = new CheckoutModel();

        // Puts data in the temp item.
        item.itemId = UUID.fromString(parts[1]);
        item.dueDate = Instant.parse(parts[2]);
        // Checks if the map already had this email.
        if (checkedOutItems.containsKey(parts[0])) {
          checkedOutItems.get(parts[0]).add(item);
        } else {
          List<CheckoutModel> checkOut = new ArrayList<>();
          checkOut.add(item);
          checkedOutItems.put(parts[0], checkOut);
        }
      }
      reader.close();
      return checkedOutItems;
    } catch (IOException e) {
      throw new RuntimeException("Failed to read media items", e);
    }
  }
}
