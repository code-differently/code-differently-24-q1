package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.Patron;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatronsRequest {
  private UUID id;
  private String name;
  private String email;

  public static LibraryGuest asLibraryGuest(PatronsRequest request) {
    String name = request.getName();
    String email = request.getEmail();
    return new Patron(name, email);
  }
}
