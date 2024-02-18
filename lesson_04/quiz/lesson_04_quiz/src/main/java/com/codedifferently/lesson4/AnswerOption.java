package com.codedifferently.lesson4;

public enum AnswerOption {
  UNANSWERED("UNANSWERED"),
  A("A"),
  B("B"),
  C("C"),
  D("D");

  private String option;

  AnswerOption(String option) {
    this.option = option;
  }

  public String getOption() {
    return option;
  }

  public String toString() {
    return option;
  }
}
