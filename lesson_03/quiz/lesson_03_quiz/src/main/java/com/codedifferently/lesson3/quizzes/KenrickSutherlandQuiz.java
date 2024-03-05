package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class KenrickSutherlandQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "kenricksutherland";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What is the hexadecimal representation of the decimal number 255?",
        Map.of(
            AnswerChoice.A, "EE",
            AnswerChoice.B, "CC",
            AnswerChoice.C, "FF",
            AnswerChoice.D, "DD"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
        1,
        "Which component of a computer is primarily responsible for executing instructions and performing calculations??",
        Map.of(
            AnswerChoice.A, "CPU",
            AnswerChoice.B, "RAM",
            AnswerChoice.C, "GPU",
            AnswerChoice.D, "SSD"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }
}
