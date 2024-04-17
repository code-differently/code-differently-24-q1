package com.codedifferently.lesson16.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatePatronRequest {
  @NotNull(message = "patron is required") @Valid
  private PatronRequest patron;
}
