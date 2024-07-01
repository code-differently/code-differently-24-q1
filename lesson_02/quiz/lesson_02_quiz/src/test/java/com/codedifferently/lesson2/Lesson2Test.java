package com.codedifferently.lesson2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.codedifferently.instructional.quiz.*;
import java.util.ArrayList;
import java.util.Comparator;
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
@ContextConfiguration(classes = Lesson2.class)
@ExtendWith(SoftAssertionsExtension.class)
class Lesson2Test {

  @Autowired private QuizConfig quizConfig;

  private List<QuizQuestion> quizQuestions;

  private SoftAssertions softly;

  private final int EXPECTED_NUMBER_OF_QUESTIONS = 11;

  @BeforeEach
  void setUp() {
    getQuestions();
    softly = new SoftAssertions();
  }

  private void getQuestions() {
    var questions = new ArrayList<QuizQuestion>(Lesson2.makeQuizQuestions());
    questions.sort(Comparator.comparingInt(QuizQuestion::getQuestionNumber));
    quizQuestions = questions;
  }

  @AfterEach
  void tearDown() {
    softly.assertAll();
  }

  @Test
  void checkQuizQuestions_areAssembledCorrectly() {
    // Expect the right number of questions.
    assertThat(quizQuestions.size())
        .as("Check # of questions")
        .isEqualTo(EXPECTED_NUMBER_OF_QUESTIONS);

    // Expect questions to be numbered correctly.
    for (int i = 0; i < quizQuestions.size(); i++) {
      assertThat(quizQuestions.get(i).getQuestionNumber())
          .as("Check question number is correct")
          .isEqualTo(i);
    }
  }

  @Test
  void checkQuizQuestions_promptsAreUnique() {
    Set<String> questionPrompts =
        quizQuestions.stream().map(QuizQuestion::getQuestionPrompt).collect(Collectors.toSet());
    assertEquals(
        EXPECTED_NUMBER_OF_QUESTIONS,
        questionPrompts.size(),
        "Expected "
            + EXPECTED_NUMBER_OF_QUESTIONS
            + " unique questions but got "
            + questionPrompts.size());
  }

  @Test
  void checkQuestions_answeredCorrectly() {
    assertThat(quizConfig.size("default")).as("Check # of answers").isEqualTo(quizQuestions.size());

    for (QuizQuestion question : quizQuestions) {
      String actualAnswer = question.getAnswer();

      // Check that the question was answered.
      softly
          .assertThat(actualAnswer)
          .as("Question " + question.getQuestionNumber() + " must be answered")
          .isNotEqualTo(AnswerChoice.UNANSWERED);

      // Check that the answer is correct.
      softly
          .assertThat(quizConfig.checkAnswer("default", question.getQuestionNumber(), actualAnswer))
          .as("Checking answer matches correct answer: " + question.getQuestionPrompt())
          .isTrue();
    }
  }
}
