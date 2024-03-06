package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class SherllinTQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "sherllint";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "An algorithm is predictable, deterministic, and not subject to chance",
        Map.of(
            AnswerChoice.A, "True",
            AnswerChoice.B, "False"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
        1,
        "Which of the following is not a strongly typed language?",
        Map.of(
            AnswerChoice.A, "Python",
            AnswerChoice.B, "JavaScript",
            AnswerChoice.C, "TypeScript",
            AnswerChoice.D, "Java"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
        
  }
}
