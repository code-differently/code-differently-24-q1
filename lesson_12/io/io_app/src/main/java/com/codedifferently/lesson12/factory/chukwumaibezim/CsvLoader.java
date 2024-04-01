package com.codedifferently.lesson12.factory.chukwumaibezim;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
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

@Service("ChukwumaLibraryCsvDataLoader")
public class CsvLoader implements LibraryCsvDataLoader {

  @Override
  public LibraryDataModel loadData() {
    LibraryDataModel libraryDataModel = new LibraryDataModel();
    try {
      libraryDataModel.mediaItems = readMediaItemsFromCsv("csv/media_items.csv");
      libraryDataModel.guests = readGuestsFromCsv("csv/guests.csv");
      populateGuestsWithCheckouts("csv/checked_out_items.csv", libraryDataModel.guests);
    } catch (IOException e) {
      throw new RuntimeException("Failed to load data from CSV files", e);
    } catch (CsvValidationException ex) {
    }
    return libraryDataModel;
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
