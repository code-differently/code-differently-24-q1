package com.codedifferently.lesson12.factory.sherllin; 

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;


@Service
public class CsvDataLoader implements LibraryCsvDataLoader {

    @Override
    public LibraryDataModel loadData() {
        LibraryDataModel model = new LibraryDataModel();
        model.mediaItems = readMediaItems();
        model.guests = new ArrayList<>(); // You can load guests similarly
        return model;
    }

List<MediaItemModel> mediaItems = readMediaItems("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/media_items.csv");
List<LibraryGuestModel> guests = readGuests("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/guests.csv");
Map<String, List<CheckoutModel>> checkoutsByGuestEmail = getCheckedOutItems("lesson_12/io/io_app/src/main/resources/csv/checked_out_items.csv");

    private List<MediaItemModel> readMediaItems(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
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
                String[] authorNames = parts[2].split(",");
                item.authors = Arrays.asList(authorNames);
                item.title = parts[3];
                items.add(item);
            }
            return items;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read media items", e);
        }
    }


    private List<LibraryGuestModel> readGuests(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
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
                String[] Names = parts[1].split(","); 
                item.names = Arrays.asList(Names); 
                item.email = parts[2]; 
                items.add(item);
            }
            return items;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read guests", e);
        }
    }
    


    private List<CheckoutModel> getCheckedOutItems(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            var items = new ArrayList<CheckoutModel>();
            String line;
            boolean isFirstLine = true; 
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; 
                    continue; 
                }
                var parts = line.split(",");
                var item = new CheckoutModel();
                item.email = parts[0]; 
                item.itemId = parts[1]; 
                item.dueDate = parts[2]; 
                items.add(item);
            }
            return items;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read checked out items", e);
        }
    }}
    

    