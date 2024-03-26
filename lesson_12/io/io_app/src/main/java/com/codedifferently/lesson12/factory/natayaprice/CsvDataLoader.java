package com.codedifferently.lesson12.factory.natayaprice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
var model = new LibraryDataModel();
model.mediaItems = new ArrayList<>(); // You load this from the file
model.guests = new ArrayList<>(); // You also load this from the file.

// STEP 1: Load each file into it's own collection
List<MediaItemModel> mediaItems = readMediaItems("/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/java/com/codedifferently/lesson12/models/MediaItemModel.java");
List<LibraryGuestModel> guests = readGuests("/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/java/com/codedifferently/lesson12/models/LibraryGuestModel.java");
Map<String, List<CheckoutModel>> checkoutsByGuestEmail = readCheckoutsByGuestEmail("/workspaces/NatayaPcode-differently-24-q1/lesson_12/io/io_app/src/main/java/com/codedifferently/lesson12/models/CheckoutModel.java");

// STEP 2: Combine checkouts with guests.
for (var guest : guests) {
var checkouts = checkoutsByGuestEmail.get(guest.email);
if (checkouts != null) {
guest.checkedOutItems = checkouts;
}
}

return model;
}

private List<MediaItemModel> readMediaItems(String string) {
try (var reader = new BufferedReader(new FileReader(string))) {
var items = new ArrayList<MediaItemModel>();
String line;
while ((line = reader.readLine()) != null) {
var parts = line.split(",");
var item = new MediaItemModel();

item.type = parts[0];
item.id = UUID.fromString(parts[1]);
item.title = parts[2];
item.type = parts[3];
items.add(item);
}
return items;
} catch (IOException e) {
throw new RuntimeException("Failed to read media items", e);
}
}

private List<LibraryGuestModel> readGuests(String filePath) {
    try (var reader = new BufferedReader(new FileReader(filePath))) {
        var guests = new ArrayList<LibraryGuestModel>();
        String line;
        while ((line = reader.readLine()) != null) {
            var parts = line.split(",");
            var guest = new LibraryGuestModel();
            
            guest.name = parts[0];
            guest.email = parts[1];
            // Assuming more properties exist in the guest model and are populated from CSV
            
            guests.add(guest);
        }
        return guests;
    } catch (IOException e) {
        throw new RuntimeException("Failed to read guests", e);
    }
}

private Map<String, List<CheckoutModel>> readCheckoutsByGuestEmail(String filePath) {
    try (var reader = new BufferedReader(new FileReader(filePath))) {
        Map<String, List<CheckoutModel>> checkoutsByGuestEmail = new HashMap<>();
        String line;
        while ((line = reader.readLine()) != null) {
            var parts = line.split(",");
            String guestEmail = parts[0];
            String checkoutData = parts[1]; // Assuming checkout data format
            // Parse checkout data and create CheckoutModel objects
            // Here you'll need to create and populate the CheckoutModel objects
            // Then add them to the list associated with the guest's email
            // Example:
            CheckoutModel checkoutModel = new CheckoutModel();
            // Populate checkoutModel fields from checkoutData
            List<CheckoutModel> checkouts = checkoutsByGuestEmail.getOrDefault(guestEmail, new ArrayList<>());
            checkouts.add(checkoutModel);
            checkoutsByGuestEmail.put(guestEmail, checkouts);
        }
        return checkoutsByGuestEmail;
    } catch (IOException e) {
        throw new RuntimeException("Failed to read checkout data", e);
    }
}

}