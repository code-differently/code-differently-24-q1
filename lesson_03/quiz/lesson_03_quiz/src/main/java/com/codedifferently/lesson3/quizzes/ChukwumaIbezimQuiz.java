package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ChukwumaIbezimQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "brooklyn";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What is the result of performing a bitwise XOR operation between the binary numbers 101011 and 110010?",
        Map.of(
            AnswerChoice.A, "010101",
            AnswerChoice.B, "011001",
            AnswerChoice.C, "111001",
            AnswerChoice.D, "101001"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1,
        "What Git command is used to display the changes between two commits?",
        ""); // Provide an answer.
  }
}
