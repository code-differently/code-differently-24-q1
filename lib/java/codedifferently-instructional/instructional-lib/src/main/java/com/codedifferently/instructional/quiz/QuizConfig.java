package com.codedifferently.instructional.quiz;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;

import at.favre.lib.crypto.bcrypt.BCrypt;
import at.favre.lib.crypto.bcrypt.BCrypt.Verifyer;

/** Loads quiz answers from the config file and uses bcrypt to check provided answers. */
@Component
@ConfigurationProperties(prefix = "quiz")
public class QuizConfig {

  private Map<String, List<String>> answersByProvider;
  private Map<String, List<QuestionConfig>> questionsByProvider;
  private Verifyer verifyer = BCrypt.verifyer();

  public void setAnswers(Map<String, List<String>> answersByProvider) {
    this.answersByProvider = answersByProvider;
  }

  public void setQuestions(Map<String, List<QuestionConfig>> questionsByProvider) {
      this.questionsByProvider = questionsByProvider;
  }

  public List<QuestionConfig> getQuestions(String provider) {
      return this.questionsByProvider.get(provider);
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

  record QuestionConfig(String prompt, Map<AnswerChoice, String> choices) {}
}
