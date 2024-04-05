package com.codedifferently.lesson16.web;

import java.util.UUID;

import com.codedifferently.lesson16.library.Patron;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatronRequest {
    private UUID id;
    private String name;
    private String email;

  public static Patron asPatron(PatronRequest request) {
    return new Patron (request.getName(), request.getEmail());
    
}
}