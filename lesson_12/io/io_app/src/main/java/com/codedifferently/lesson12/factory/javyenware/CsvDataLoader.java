package com.codedifferently.lesson12.factory.javyenware;

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

@Service
public class CsvDataLoader implements LibraryCsvDataLoader {

  @Override
  public LibraryDataModel loadData() {
    LibraryDataModel libraryDataModel = new LibraryDataModel();
    try {
      libraryDataModel.mediaItems = readMediaItemsFromCsv("csv/media_items.csv");
      libraryDataModel.guests = readGuestsFromCsv("csv/guests.csv");
      populateGuestsWithCheckouts("csv/checked_out_items.csv", libraryDataModel.guests);
    } catch (IOException | CsvValidationException e) {
      throw new RuntimeException("Failed to load data from CSV files", e);
    }
    return libraryDataModel;
  }

  private List<MediaItemModel> readMediaItemsFromCsv(String filePath)
      throws IOException, CsvValidationException {
    List<MediaItemModel> mediaItems = new ArrayList<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      reader.skip(1);
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
      reader.skip(1);
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

  //  populatGuestsWithCheckouts is a method taking two parameters. String filePath is representing the path to the csv file. 
  // And <List<LibraryGuestModel> guests is the second parameter and this parameter is a list of LibraryGuestModel objects which represent guests in a library system. 
  // A object represents a real world entity or data structure (it can hold both variable and methods)
  // throw keyword in java is used to throw an exception from a method. And the throws IOException, CsvValidationException means that if theres any difficultiy reading the csv file or verifying the information within the csv file this method will then throw a exception 
  private void populateGuestsWithCheckouts(String filePath, List<LibraryGuestModel> guests)
      throws IOException, CsvValidationException {

        // Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>(); starts a new hashmap (a hashmap is data strcuture used to store data as a key value pair.)
        // The difference between a hashmap and a map is that a hashmap is less flexible and uses a hashtable for fast access)( a hashtable is a collection of key-value pairs, for each value you have a unique key for it)
        // try keyword allows you to run and test a block of code for errors while said code block is being executed
        
    Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();
    try (CSVReader reader =
        new CSVReader(new FileReader(new ClassPathResource(filePath).getFile()))) {
      reader.skip(1);
      String[] line;
      while ((line = reader.readNext()) != null) {
        String email = line[0];
        CheckoutModel checkout = new CheckoutModel();
        checkout.itemId = UUID.fromString(line[1]);
        checkout.dueDate = Instant.parse(line[2]);
        checkoutsByGuestEmail.computeIfAbsent(email, k -> new ArrayList<>()).add(checkout);
      }
    }
    guests.forEach(
        guest ->
            guest.setCheckedOutItems(
                checkoutsByGuestEmail.getOrDefault(guest.getEmail(), new ArrayList<>())));
  }
}
