package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class NatayaPriceQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "natayaprice";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "Programmable read-only memory (PROM) chips can be programmed..",
        Map.of(
            AnswerChoice.A, "Once",
            AnswerChoice.B, "Twice",
            AnswerChoice.C, "However many times you would like to",
            AnswerChoice.D, "Every so often"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new MultipleChoiceQuizQuestion(
        1,
        "Who designed and programmed the VisiCalc?",
        Map.of(
            AnswerChoice.A, "Alan Kay and Douglas Engelbart",
            AnswerChoice.B, "Ken Thompson and Dennis Ritchie",
            AnswerChoice.C, "Dan Bricklin and Bob Frankston",
            AnswerChoice.D, "Tom and Jerry"),
        AnswerChoice.UNANSWERED); // Replace `UNANSWERED` with the correct answer.
  }
}
