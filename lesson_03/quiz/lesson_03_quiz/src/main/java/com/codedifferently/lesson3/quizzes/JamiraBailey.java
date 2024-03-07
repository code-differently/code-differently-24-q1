package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JamiraBailey implements QuizQuestionProvider {

  public String getProviderName() {
    return "jamirabailey";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "How many bits are in a byte in binary notation?",
        Map.of(
            AnswerChoice.A, "4",
            AnswerChoice.B, "6",
            AnswerChoice.C, "8",
            AnswerChoice.D, "10"),
        AnswerChoice.C); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1, "What does CPU stand for?", "Central Processing Unit"); // Provide an answer.
  }
}
