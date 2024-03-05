package com.codedifferently.lesson3.quizzes;

import com.codedifferently.instructional.quiz.AnswerChoice;
import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.codedifferently.instructional.quiz.QuizQuestionProvider;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class RandycastroQuiz implements QuizQuestionProvider {

  public String getProviderName() {
    return "randycastro";
  }

  public List<QuizQuestion> makeQuizQuestions() {
    return List.of(makeQuestion0(), makeQuestion1());
  }

  private QuizQuestion makequestion0() {
    return new MultipleChoiceQuizQuestion(
        0,
        "What does CPU stand for?",
        Map.of(
            AnswerChoice.A, "Central Processing Unit",
            AnswerChoice.B, "Computer Power Unit",
            AnswerChoice.C, "Control Processing Unit",
            AnswerChoice.D, "Central Power Unit"),
        AnswerChoice.UNANSWERED) ; // Replace `UNANSWERED` with the correct answer.
  }
      

private QuizQuestion makeQuestion1() {
  return new MultipleChoiceQuizQuestion(
      1,
      "Which of the following is a type of computer memory that is volatile and loses its contents when the power is turned off?",
      Map.of(
          AnswerChoice.A, "ROM (Read-Only Memory)",
          AnswerChoice.B, "RAM (Random Access Memory)",
          AnswerChoice.C, "HDD (Hard Disk Drive)",
          AnswerChoice.D, "SSD (Solid State Drive)"),
      AnswerChoice.UNANSWERED); // B) RAM (Random Access Memory) is the correct answer.

      
      
    private QuizQuestion makeQuestion2() {
        return new MultipleChoiceQuizQuestion(
            2,
            "What is the purpose of a compiler in programming?",
            Map.of(
                AnswerChoice.A, "To convert high-level programming code into machine code",
                AnswerChoice.B, "To debug code and fix errors",
                AnswerChoice.C, "To optimize code for performance",
                AnswerChoice.D, "To provide a user interface for coding"),
            AnswerChoice.UNANSWERED); // A) To convert high-level programming code into machine code is the correct answer.
    }
    




