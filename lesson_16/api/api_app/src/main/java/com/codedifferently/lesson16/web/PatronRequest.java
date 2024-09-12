package com.codedifferently.lesson16.web;

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
  private String name;
  private String email;
}
