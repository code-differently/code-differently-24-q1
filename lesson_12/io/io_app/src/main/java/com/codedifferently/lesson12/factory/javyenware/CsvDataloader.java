package com.codedifferently.lesson12.factory.javyenware;

import com.codedifferently.lesson12.factory.LibraryCsvDataLoader;
import com.codedifferently.lesson12.models.LibraryDataModel;
import org.springframework.stereotype.Service;

@Service
public class CsvDataloader implements LibraryCsvDataLoader {
    @Override
    public LibraryDataModel loadData(){

        
        return null;
    }
}