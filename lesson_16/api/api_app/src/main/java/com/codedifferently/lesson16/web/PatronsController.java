package com.codedifferently.lesson16.web;

import java.io.IOException;

import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class PatronsController {
    private final Library library;
    

    public PatronsController(Library library) throws IOException {
        this.library = library;

    }

    @GetMapping("list of patrons")
    public GetPatronsController getListOfPatrons() {
        
    }







}
