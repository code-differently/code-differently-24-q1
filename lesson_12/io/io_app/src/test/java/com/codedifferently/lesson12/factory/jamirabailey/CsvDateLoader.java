package com.codedifferently.lesson12.factory.jamirabailey;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CsvDataLoader implements LibraryCsvDataLoader {

    @Override
    public LibraryDataModel loadData() {
        LibraryDataModel model = new LibraryDataModel();
        model.mediaItems = readMediaItems("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/media_items.csv");
        model.guests = readGuests("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/guests.csv");
        model.checkoutsByGuestEmail = readCheckoutsByGuestEmail("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/checkouts_by_guest_email.csv");
        return model;
    }

    private List<MediaItemModel> readMediaItems(String filePath) {
        List<MediaItemModel> mediaItems = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                MediaItemModel item = new MediaItemModel();
                item.setType(parts[0]);
                item.setId(UUID.fromString(parts[1]));
                item.setTitle(parts[2]);
                item.setType(parts[3]);
                mediaItems.add(item);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read media items", e);
        }
        return mediaItems;
    }

    private List<LibraryGuestModel> readGuests(String filePath) {
        List<LibraryGuestModel> guests = new ArrayList<>();
        // Implement reading guests from CSV file
        return guests;
    }

    private Map<String, List<CheckoutModel>> readCheckoutsByGuestEmail(String filePath) {
        Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();
        // Implement reading checkouts from CSV file
        return checkoutsByGuestEmail;
    }
}
