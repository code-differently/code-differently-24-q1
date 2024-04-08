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

  @NotBlank(message = "Email is required")
  private String email;

  @NotBlank(message = "Name is required")
  private String name;

  public static Patron asPatron(PatronRequest request) {
    return new Patron(request.name, request.email);
  }
}
