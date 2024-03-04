package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class RichHawkinsQuiz implements QuizQuestionProvider {

  public String getProviderName() {                               
    return "richhawkins";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "How many bits are in a byte?",
        Map.of(
            AnswerChoice.A, "2",
            AnswerChoice.B, "6",
            AnswerChoice.C, "12",
            AnswerChoice.D, "8"),
        AnswerChoice.D); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(1, "What is 2A in decimal?", "42"); // Provide an answer.
  }
}
