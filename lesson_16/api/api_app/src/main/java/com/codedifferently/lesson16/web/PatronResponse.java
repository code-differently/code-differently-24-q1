package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.LibraryGuest;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatronResponse {

  private UUID id;
  private String name;
  private String email;

  /**
   * Converts a Patron object to a PatronResponse object.
   *
   * @param patron The Patron object to convert.
   * @return The converted PatronResponse object.
   */
  public static PatronResponse from(LibraryGuest patron) {
    return PatronResponse.builder()
        .id(patron.getId())
        .name(patron.getName())
        .email(patron.getEmail())
        .build();
  }
}
