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

  public static PatronResponse from(LibraryGuest guest) {
    return PatronResponse.builder()
        .id(guest.getId())
        .name(guest.getName())
        .email(guest.getEmail())
        .build();
  }
}
