package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AaronSantiagoQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "aaronsantiago";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What is Object Oriented Programming?",
        Map.of(
            AnswerChoice.A,
            "A programming language model organized around objects rather than actions, and data rather than logic.",
            AnswerChoice.B,
            "A programming convention that only allows for the use of specific Objects.",
            AnswerChoice.C,
            "Using Objects to program.",
            AnswerChoice.D,
            "A paradigm of building computer programs using expressions and functions without mutating state and data."),
        AnswerChoice.UNANSWERED);
  }

  private QuizQuestion makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
        1,
        "Which data type is used to represent textual data in Java?",
        Map.of(
            AnswerChoice.A, "int",
            AnswerChoice.B, "String",
            AnswerChoice.C, "boolean",
            AnswerChoice.D, "float"),
        AnswerChoice.UNANSWERED);
  }
}
