package com.codedifferently.lesson3.quizzes;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;

@Service
public class JordanEldridgeQuiz implements QuizQuestionProvider {

      public String getProviderName() {
    return "JordanEldridge";
  }

   public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What is the size of float and double in java?",
        Map.of(
            AnswerChoice.A,
            "34 and 64",
            AnswerChoice.B,
            "32 and 32",
            AnswerChoice.C,
            "34 and 34",
            AnswerChoice.D,
            "64 and 32"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
        1,
        "Arrays in java are-",
        Map.of(AnswerChoice.A, "Object references", AnswerChoice.B, "objects", AnswerChoice.C, "Primitive data type", AnswerChoice.D, "none"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }
 
    
}
