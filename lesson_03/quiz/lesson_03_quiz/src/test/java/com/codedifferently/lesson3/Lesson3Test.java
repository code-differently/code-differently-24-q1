package com.codedifferently.lesson3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

@SpringBootTest
@ContextConfiguration(classes = Lesson3.class)
@ExtendWith(SoftAssertionsExtension.class)
class Lesson3Test {

  @Autowired private QuizAnswers quizAnswers;

  private List<QuizQuestion> quizQuestions = Lesson3.makeQuizQuestions();

  private SoftAssertions softly;

  @BeforeEach
  void setUp() {
    softly = new SoftAssertions();
  }

  @AfterEach
  void tearDown() {
    softly.assertAll();
  }

  @Test
  void checkQuizQuestions_areAssembledCorrectly() {
    assertThat(quizQuestions.size()).as("Check # of questions").isEqualTo(6);
    for (int i = 0; i < quizQuestions.size(); i++) {
      assertThat(quizQuestions.get(i).getQuestionNumber())
          .as("Check question number is correct")
          .isEqualTo(i);
    }
  }

  void checkQuizQuestions_areUnique() {
    Set<String> questionPrompts =
        quizQuestions.stream().map(QuizQuestion::getQuestionPrompt).collect(Collectors.toSet());
    assertEquals(
        6, questionPrompts.size(), "Expected 6 unique questions but got " + questionPrompts.size());
  }

  @Test
  void checkQuestions_answeredCorrectly() {
    assertThat(quizAnswers.size()).as("Check # of answers").isEqualTo(quizQuestions.size());

    for (QuizQuestion question : quizQuestions) {
      AnswerOption actualAnswer = question.getAnswer();

      // Check that the question was answered
      softly
          .assertThat(actualAnswer)
          .as("Question " + question.getQuestionNumber() + " must be answered")
          .isNotEqualTo(AnswerOption.UNANSWERED);

      // Check that the answer is correct
      softly
          .assertThat(quizAnswers.checkAnswer(question.getQuestionNumber(), actualAnswer))
          .as(
              "Checking question "
                  + question.getQuestionNumber()
                  + ": "
                  + question.getQuestionPrompt())
          .isTrue();
    }
  }
}
