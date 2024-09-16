package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.LibraryGuest;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatronsResponse {
  private UUID id;
  private String name;

  public static PatronsResponse from(LibraryGuest guest) {
    return builder().id(guest.getId()).name(guest.getName()).build();
  }

  public static List<PatronsResponse> from(Collection<LibraryGuest> guests) {
    return guests.stream().map(PatronsResponse::from).collect(Collectors.toList());
  }
}
