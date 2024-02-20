package com.codedifferently.instructional.quiz;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Verifyer;
import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** Loads quiz answers from the config file and uses bcrypt to check provided answers. */
@Component
@ConfigurationProperties(prefix = "quiz")
public class QuizAnswers {

  private List<String> answers;

  private Verifyer verifyer = BCrypt.verifyer();

  public void setAnswers(List<String> answers) {
    this.answers = answers;
  }

  public boolean checkAnswer(int questionNumber, String actualAnswer) {
    return verifyer
        .verify(actualAnswer.toCharArray(), answers.get(questionNumber))
        .verified;
  }

  public int size() {
    return answers.size();
  }
}
