package com.codedifferently.lesson16.web;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePatronResponse {
  private PatronResponse patron;

  // public CreatePatronResponse(PatronResponse patron) {
  //     this.patron = patron;
  // }

  // public PatronResponse getPatron() {
  //     return patron;
  // }

  // public void setPatron(PatronResponse patron) {
  //     this.patron = patron;
  // }
}