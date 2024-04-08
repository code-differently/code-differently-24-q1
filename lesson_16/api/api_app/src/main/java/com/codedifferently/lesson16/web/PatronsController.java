package com.codedifferently.lesson16.web;

import org.apache.tomcat.jni.Library;
import org.springframework.web.bind.annotation.GetMapping;




public class PatronsController {
    private final Library library;
    private final 
    

    public PatronsController(Library library) {
        this.library = library;
    }
    @GetMapping("list of patrons")
    public GetPatronsController getListOfPatrons() {
        
    }
}
