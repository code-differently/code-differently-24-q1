package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MohamedIbrahimQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "moibrahi7";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What are essential parts to building a computer? (without the inclusion of a case)",
        Map.of(
            AnswerChoice.A, "CPU, RAM, MOTHERBOARD, GPU, CPU COOLER",
            AnswerChoice.B, "RAM, MOTHERBOARD, HARD DRIVE, GPU, CPU COOLER",
            AnswerChoice.C, "RAM, CPU, HARD DRIVE, MOTHERBOARD, CPU COOLER",
            AnswerChoice.D, "RAM, HARD DRIVE, GPU"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1, "What is the base 10 equivalent of 547 in base 8?", "0000"); // Provide an answer.
  }
}
