package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class KevinMasonQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "kevinmason";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What is the command for changing branches in git??",
        Map.of(
            AnswerChoice.A, "git pull",
            AnswerChoice.B, "git push",
            AnswerChoice.C, "git checkout",
            AnswerChoice.D, "get checkout"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1,
        "What is the binary representation of the decimal number 12?",
        "1000"); // Provide an answer.
  }
}
