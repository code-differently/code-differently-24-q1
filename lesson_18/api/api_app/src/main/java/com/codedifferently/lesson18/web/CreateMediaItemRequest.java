package com.codedifferently.lesson18.web;

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
public class CreateMediaItemRequest {
  @NotNull(message = "item is required") @Valid
  private MediaItemRequest item;
}
