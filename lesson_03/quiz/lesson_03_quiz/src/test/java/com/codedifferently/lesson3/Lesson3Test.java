package com.codedifferently.lesson3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.QuizConfig;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.EnabledIf;

@SpringBootTest
@ContextConfiguration(classes = Lesson3.class)
@ExtendWith(SoftAssertionsExtension.class)
class Lesson3Test {

  @Autowired private QuizConfig quizConfig;

  @Autowired private List<QuizQuestionProvider> quizQuestionsProviders;

  private Map<String, List<QuizQuestion>> quizQuestionsByProvider;

  private SoftAssertions softly;

  private final int EXPECTED_NUMBER_OF_QUESTIONS = 2;

  @BeforeEach
  void setUp() {
    makeQuestions();
    softly = new SoftAssertions();
  }

  private void makeQuestions() {
    quizQuestionsByProvider = new HashMap<>();
    for (QuizQuestionProvider provider : quizQuestionsProviders) {
      if (quizQuestionsByProvider.containsKey(provider.getProviderName())) {
        throw new IllegalStateException("Duplicate provider name: " + provider.getProviderName());
      }
      List<QuizQuestion> questions = new ArrayList<>(provider.makeQuizQuestions());
      questions.sort(Comparator.comparingInt(QuizQuestion::getQuestionNumber));
      quizQuestionsByProvider.put(provider.getProviderName(), questions);
    }
  }

  @AfterEach
  void tearDown() {
    softly.assertAll();
  }

  @Test
  void checkQuizQuestions_areAssembledCorrectly() {
    for (var entry : quizQuestionsByProvider.entrySet()) {
      String providerName = entry.getKey();
      List<QuizQuestion> quizQuestions = entry.getValue();

      // Expect the right number of questions.
      assertThat(quizQuestions.size())
          .as("Check # of questions for " + providerName)
          .isEqualTo(EXPECTED_NUMBER_OF_QUESTIONS);

      // Expect questions to be numbered correctly.
      for (int i = 0; i < quizQuestions.size(); i++) {
        assertThat(quizQuestions.get(i).getQuestionNumber())
            .as("Check question number is correct for " + providerName)
            .isEqualTo(i);
      }
    }
  }

  @Test
  void checkQuizQuestions_promptsAreUnique() {
    for (var entry : quizQuestionsByProvider.entrySet()) {
      String providerName = entry.getKey();
      List<QuizQuestion> quizQuestions = entry.getValue();

      Set<String> questionPrompts =
          quizQuestions.stream().map(QuizQuestion::getQuestionPrompt).collect(Collectors.toSet());
      assertEquals(
          EXPECTED_NUMBER_OF_QUESTIONS,
          questionPrompts.size(),
          "Expected "
              + EXPECTED_NUMBER_OF_QUESTIONS
              + " unique questions for provider "
              + providerName
              + " but got "
              + questionPrompts.size());
    }
  }

  @Test
  void checkQuestions_haveAnswers() {
    for (var entry : quizQuestionsByProvider.entrySet()) {
      String providerName = entry.getKey();
      List<QuizQuestion> quizQuestions = entry.getValue();

      assertThat(quizConfig.size(providerName))
          .as("Check # of answers for provider " + providerName)
          .isGreaterThanOrEqualTo(quizQuestions.size());
    }
  }

  @Test
  @EnabledIf(value = "#{environment.getActiveProfiles()[0] == 'prod'}", loadContext = true)
  void checkQuestions_answeredCorrectly() {
    for (var entry : quizQuestionsByProvider.entrySet()) {
      String providerName = entry.getKey();
      List<QuizQuestion> quizQuestions = entry.getValue();

      for (QuizQuestion question : quizQuestions) {
        String actualAnswer = question.getAnswer();

        // Check that the question was answered.
        softly
            .assertThat(actualAnswer)
            .as("Question " + question.getQuestionNumber() + " must be answered")
            .isNotEqualTo(AnswerChoice.UNANSWERED);

        // Check that the answer is correct.
        softly
            .assertThat(
                quizConfig.checkAnswer(providerName, question.getQuestionNumber(), actualAnswer))
            .as("Checking answer matches correct answer: " + question.getQuestionPrompt())
            .isTrue();
      }
    }
  }
}
