package com.codedifferently.lesson16.web;

import com.codedifferently.lesson16.library.Patron;
import java.util.UUID;
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

  public static PatronsResponse from(Patron patron) {
    return null;
  }
}
