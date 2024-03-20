package com.codedifferently.instructional.quiz;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Verifyer;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/** Loads quiz answers from the config file and uses bcrypt to check provided answers. */
@Component
@ConfigurationProperties(prefix = "quiz")
public class QuizAnswers {

  private Map<String, List<String>> answersByProvider;

  private Verifyer verifyer = BCrypt.verifyer();

  public void setAnswers(Map<String, List<String>> answersByProvider) {
    this.answersByProvider = answersByProvider;
  }

  public boolean checkAnswer(String provider, int questionNumber, String actualAnswer) {
    List<String> answers = answersByProvider.get(provider);
    Objects.requireNonNull(answers, "No answers found for provider: " + provider);
    return verifyer
        .verify(actualAnswer.toCharArray(), answers.get(questionNumber))
        .verified;
  }

  public int size(String provider) {
    if (!answersByProvider.containsKey(provider)) {
        return 0;
    }
    return answersByProvider.get(provider).size();
  }
}
