package com.codedifferently.lesson16.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePatronResponse {
  private PatronResponse patron;
}
