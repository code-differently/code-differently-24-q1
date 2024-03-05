package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class VicenteVigueras implements QuizQuestionProvider {

  public String getProviderName() {
    return "vicentevigueras";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What are the colors of the Chilean flag",
        Map.of(
            AnswerChoice.A, "Light blue, yellow, and white",
            AnswerChoice.B, "Green, yellow, black",
            AnswerChoice.C, "Blue, gray, and red",
            AnswerChoice.D, "Red, blue, and white"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
        1,
        "What is the third Newton Law",
        Map.of(
            AnswerChoice.A,
                "An object at rest remains at rest, and an object in motion remains in motion at constant speed and in a straight line unless acted on by an unbalanced force.",
            AnswerChoice.B, "For a spontaneous process, the entropy of the universe increases.",
            AnswerChoice.C,
                "Whenever one object exerts a force on another object, the second object exerts an equal and opposite on the first.",
            AnswerChoice.D,
                "The acceleration of an object depends on the mass of the object and the amount of force applied."),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }
}