package com.codedifferently.instructional.quiz;

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

  public String toString() {
    return option;
  }
}
