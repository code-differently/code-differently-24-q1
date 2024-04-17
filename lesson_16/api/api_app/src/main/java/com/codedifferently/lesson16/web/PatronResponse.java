package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Patron;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatronResponse {

  private UUID id;
  private String name;
  private String email;

  public static PatronResponse from(Patron patron) {
    var result =
        PatronResponse.builder().id(patron.getId()).name(patron.getName()).email(patron.getEmail());

    return result.build();
  }
}
