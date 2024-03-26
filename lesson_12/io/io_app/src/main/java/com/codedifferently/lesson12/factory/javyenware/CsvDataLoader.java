package com.codedifferently.lesson12.factory.javyenware;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.LibraryDataModel;

import org.springframework.stereotype.Service;

import com.codedifferently.lesson12.models.MediaItemModel;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;


@Service
public class CsvDataLoader implements LibraryCsvDataLoader {
    @Override
    public LibraryDataModel loadData() {
        var model = new LibraryDataModel();
        model.mediaItems = new ArrayList<>(); // loading this from the file
        model.guests = new ArrayList<>(); // also gets loaded from the original file 

        List<MediaItemModel> mediaItems = readmediaItems();
        List<LibraryGuestModel> guests = readGuests();
        Map<String, List<CheckoutModel>> checkoutByGuestEmail = getCheckedoutItems();

        for (String guest : guest) {
            var checkouts = checkoutByGuestEmail.get(guest.email);
            if (checkouts ! null) {
                guest.checkoutByGuestEmail = checkouts;
            }
        }

        return null;
    }

    private List<MediaItemModel> readMediaItems(String path){
        var items = new ArrayList<MediaItemModel>();
            for (string row : readCsvfile(path)) {
                var item = new MediaItemModel();
                
            }
    }


}