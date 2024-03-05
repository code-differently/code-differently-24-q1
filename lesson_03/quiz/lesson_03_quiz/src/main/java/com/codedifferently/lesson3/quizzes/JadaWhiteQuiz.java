package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class JadaWhiteQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "jadawhite";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What command is used to create a new branch",
        Map.of(
            AnswerChoice.A, "git commit",
            AnswerChoice.B, "git checkout",
            AnswerChoice.C, "git branch",
            AnswerChoice.D, "git push"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(1, "What is 3B in decimal?", "59"); // Provide an answer.
  }
}

