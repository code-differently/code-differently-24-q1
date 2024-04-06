package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.LibraryGuest;
import com.codedifferently.lesson16.library.Patron;
import jakarta.validation.constraints.NotBlank;
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

  @NotBlank(message = "Name is required")
  private String name;

  @NotBlank(message = "Email is required")
  private String email;

  public static LibraryGuest asLibraryGuest(PatronsRequest request) {
    UUID id = request.getId();
    String name = request.getName();
    String email = request.getEmail();

    return new Patron(name, email);
  }
}
