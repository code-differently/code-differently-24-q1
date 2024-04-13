package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.LibraryGuest;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatronResponse {
  private UUID id;

  @NotBlank(message = "Email is required")
  private String email;

  @NotBlank(message = "Name is required")
  private String name;

  public static PatronResponse from(LibraryGuest patron) {
    var result =
        PatronResponse.builder().id(patron.getId()).name(patron.getName()).email(patron.getEmail());
    return result.build();
  }
}
