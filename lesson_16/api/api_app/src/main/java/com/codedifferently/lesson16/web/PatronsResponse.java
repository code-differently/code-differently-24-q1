package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.LibraryGuest;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Data;

/**
 * @author vscode
 */
@Data
@Builder
public class PatronsResponse {
  private UUID id;
  private String name;
  private String email;

  public static PatronsResponse from(LibraryGuest patron) {
    return PatronsResponse.builder().id(patron.getId()).name(patron.getName()).build();
  }

  public static List<PatronsResponse> from(Collection<LibraryGuest> patrons) {
    return patrons.stream().map(PatronsResponse::from).collect(Collectors.toList());
  }
}
