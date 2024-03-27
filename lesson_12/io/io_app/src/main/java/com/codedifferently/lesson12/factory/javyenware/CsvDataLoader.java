package com.codedifferently.lesson12.factory.javyenware;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import com.codedifferently.lesson12.models.LibraryGuestModel;
import com.codedifferently.lesson12.models.MediaItemModel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codedifferently.lesson12.library.LibraryGuestBase;

@Service
public class CsvDataLoader implements LibraryCsvDataLoader {

    @Override
    public LibraryDataModel loadData() {
        var model = new LibraryDataModel();
        model.mediaItems = new ArrayList<>(); // loading this from the file
        model.guests = new ArrayList<>(); // also gets loaded from the original file

        List<MediaItemModel> mediaItems = readMediaItems("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/media_items.csv");
        List<LibraryGuestModel> guests = readGuests("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/guests.csv");
        Map<String, List<CheckoutModel>> checkoutByGuestEmail = getCheckedoutItems("/workspaces/code-differently-24-q1/lesson_12/io/io_app/src/main/resources/csv/checked_out_items.csv");

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


    private List<LibraryGuestModel> readguestList(String path) {
        var items = new ArrayList<LibraryGuestModel>();
        for (String row)
    }



}
