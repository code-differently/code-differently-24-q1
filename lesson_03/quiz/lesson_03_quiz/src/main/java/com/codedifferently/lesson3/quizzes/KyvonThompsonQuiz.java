package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class KyvonThompsonQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "kyvonthompson";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What type of layer do apply effects to in order to manipulate the layers under it?",
        Map.of(
            AnswerChoice.A, "A solid",
            AnswerChoice.B, "A null void",
            AnswerChoice.C, "An adjustment layer",
            AnswerChoice.D, "A composition"),
        AnswerChoice.C); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1, "What is kyvon's favorite form of art?", "Mixed media"); // Provide an answer.
  }
}
