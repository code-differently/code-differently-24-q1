package com.codedifferently.lesson12.factory.randycastro;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

// create a path for each file
@Service
public class CsvDataLoader implements LibraryCsvDataLoader {
  public static void main(String[] args) throws IOException {
    new CsvDataLoader().loadData();
  }

  @Override
  public LibraryDataModel loadData() throws IOException {
    {
      var model = new LibraryDataModel();
      model.mediaItems = new ArrayList<>(); // You load this from the file
      model.guests = new ArrayList<>(); // You also load this from the file.

      List<MediaItemModel> mediaItems =
          readMediaItems("lesson_12/io/io_app/src/main/resources/csv/media_items.csv");
      List<LibraryGuestModel> guests = readGuests("path/to/guests.csv");
      Map<String, List<CheckoutModel>> checkoutsByGuestEmail =
          getCheckedOutItems("path/to/checked_out_items.csv");

      for (var guest : guests) {
        var checkouts = checkoutsByGuestEmail.get(guest.email);
        if (checkouts != null) {
          guest.checkedOutItems = checkouts;
        }
      }

      return model;
    }
  }

  public static List<MediaItemModel> readMediaItems(String Path) {
    try (BufferedReader reader =
        new BufferedReader(new FileReader(new ClassPathResource(path).getFile()))) {
      List<MediaItemModel> items = new ArrayList<>();
      String line;
      while ((line = reader.readLine()) != null) {
        var parts = line.split(",");
        var item = new MediaItemModel();

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
}

 /*List<MediaItemModel> readMediaItems(String filePath) {
 List<MediaItemModel> items = new ArrayList<>();
 try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
     String line;
     while ((line = reader.readLine()) != null) {
         String[] parts = line.split(",");
          MediaItemModel item = new MediaItemModel();
                 item.setType(parts[0]);
                 item.setId(parts[1]);
                 item.setAuthor(parts[2]);
                 item.setTitle(parts[3]); // Assuming 'title' instead of 'type' again
                 items.add(item);
             }
         } catch (IOException e) {
             e.printStackTrace();
             // Handle the exception appropriately
         }
         return items;
     }
 }*/
