package com.codedifferently.lesson3;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class MekhiQuiz implements QuizQuestionProvider {

  @Override
  public String getProviderName() {
    return "mekhiwilliams";
  }

  @Override
  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makeQuestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "Which programming language is known for its versatility and use in web development?",
        Map.of(
            AnswerChoice.A,
            "Java",
            AnswerChoice.B,
            "Python",
            AnswerChoice.C,
            "C++",
            AnswerChoice.D,
            "JavaScript"),
        AnswerChoice.UNANSWERED); // SOLVE
  }

  private QuizQuestion makeQuestion1() {
    return new QuizQuestion(1, "What does CPU stand for?", ""); // SOLVE
  }
}
