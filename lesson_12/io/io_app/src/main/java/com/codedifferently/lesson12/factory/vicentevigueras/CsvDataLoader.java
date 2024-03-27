package com.codedifferently.lesson12.factory.vicentevigueras;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * @author vscode
 */
@Service
public class CsvDataLoader implements LibraryCsvDataLoader {
  public static void main(String[] args) throws IOException {
    CsvDataLoader csvDataLoader = new CsvDataLoader();
    csvDataLoader.loadData();
   
  }

  @Override
  public LibraryDataModel loadData() throws IOException {
    // Create object named model that is an instance of LibraryDataModel
    var model = new LibraryDataModel();
    // Creates a list and assigns it everything inside of file path
    model.mediaItems = readMediaItems("csv/media_items.csv");
    return model;
  }

  // Read data after loading it.
  private List<MediaItemModel> readMediaItems(String resource) throws IOException {
    File myResource = new ClassPathResource(resource).getFile();
    String fileContent = new String(Files.readAllBytes(myResource.toPath()));

    var items = new ArrayList<MediaItemModel>();
    String[] eachLine = fileContent.split("\n");

    for (int i = 1; i < eachLine.length; i++) {
      String[] parts = eachLine[i].split(",", -1);
      System.out.println("size of line:" + parts.length);
      System.out.println("printing line: i:" + i + " line:" + eachLine[i]);
      System.out.println("part0:" + parts[0]);
      System.out.println("part1:" + parts[1]);
      System.out.println("part2:" + parts[2]);
      System.out.println("part3:" + parts[3]);
      System.out.println("part4:" + parts[4]);
      System.out.println("part5:" + parts[5]);
      System.out.println("part6:" + parts[6]);
      System.out.println("part6:" + parts[7]);
      var item = new MediaItemModel();

      System.out.println("printing line: i:" + i + " line:" + eachLine[i]);
      // Parse as proper data types
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
      } else {
        item.edition = "";
      }

      items.add(item);
    }
    System.out.println(items);
    return items;
  }
}
