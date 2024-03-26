package com.codedifferently.lesson12.factory.javyenware;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.MediaItemModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CsvDataLoader implements LibraryCsvDataLoader {

    @Override
    public LibraryDataModel loadData() {
        var model = new LibraryDataModel();
        model.mediaItems = new ArrayList<>(); // loading this from the file
        model.guests = new ArrayList<>(); // also gets loaded from the original file

        List<MediaItemModel> mediaItems = readMediaItems();
        List<LibraryGuestModel> guests = readGuests();
        Map<String, List<CheckoutModel>> checkoutByGuestEmail = getCheckedoutItems();

        for (LibraryGuestModel guest : guests) {
            var checkouts = checkoutByGuestEmail.get(guest.email);
            if (checkouts != null) {
                guest.checkoutByGuestEmail = checkouts;
            }
        }

        return model;
    }

    private List<MediaItemModel> readMediaItems(String path) {
        var items = new ArrayList<MediaItemModel>();
        for (String row : readCsvfile(path)) {
            var item = new MediaItemModel();
            item.id = row.get();
            item.title = row.get();
            item.type = row.get();
            items.add(item);
        }
        return items;
    }

}
