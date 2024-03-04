package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AnthonyMaysQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "anthonymays";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What is a multiple choice question?",
        Map.of(
            AnswerChoice.A, "A question about agency",
            AnswerChoice.B, "The hardest kind of quiz question there is",
            AnswerChoice.C, "A question that can be answered using one or more provided choices",
            AnswerChoice.D, "Whatever you want it to be!"),
        AnswerChoice.C); // Replace `UNANSWERED` with the correct answer.
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(
        1,
        "What is a computer?",
        "A machine that automatically transforms input into output."); // Provide an answer.
  }
}
