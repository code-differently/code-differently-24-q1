package com.codedifferently.lesson16.web;

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
public class PatronRequest {
  private UUID id;

  @NotBlank(message = "name is required")
  private String name;

  @NotBlank(message = "email is required")
  private String email;

  public static Patron asPatron(PatronRequest request) {
    String name = request.getName();
    String email = request.getEmail();

    return new Patron(name, email);
  }
}
