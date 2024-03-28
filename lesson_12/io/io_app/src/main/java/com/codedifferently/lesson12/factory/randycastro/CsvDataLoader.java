package com.codedifferently.lesson12.factory.randycastro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;


// create a path for each file 
@Service
public class CsvDataLoader implements LibraryCsvDataLoader{
    @Override
    public LibraryDataModel loadData() {
    var model = new LibraryDataModel();
    model.mediaItems = new ArrayList<>(); // You load this from the file
    model.guests = new ArrayList<>(); // You also load this from the file.

List<MediaItemModel> mediaItems = readMediaItems("lesson_12/io/io_app/src/main/resources/csv/media_items.csv");
List<LibraryGuestModel> guests = readGuests("path/to/guests.csv");
Map<String, List<CheckoutModel>> checkoutsByGuestEmail = getCheckedOutItems("path/to/checked_out_items.csv");

for (var guest : guests) {
    var checkouts = checkoutsByGuestEmail.get(guest.email);
    if (checkouts != null) {
    guest.checkedOutItems = checkouts;
    }
    }
    
    return model;
    }
    private List<MediaItemModel> readMediaItems(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
        var items = new ArrayList<MediaItemModel>();
        String line;
        while ((line = reader.readLine()) != null) {
        var parts = line.split(",");
        var item = new MediaItemModel();
        
        item.type = parts[0];
        item.id = parts[1];
        item.author = parts[2];
        item.type = parts[3];
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





