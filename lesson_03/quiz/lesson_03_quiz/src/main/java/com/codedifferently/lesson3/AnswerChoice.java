package com.codedifferently.lesson3;

public enum AnswerChoice {
  UNANSWERED("UNANSWERED"),
  A("A"),
  B("B"),
  C("C"),
  D("D");

  private String option;

  AnswerChoice(String option) {
    this.option = option;
  }

  public String getOption() {
    return option;
  }

  public String toString() {
    return option;
  }
}
