package com.codedifferently.quiz.lesson10;

import com.codedifferently.instructional.quiz.QuizConfig;
import com.codedifferently.instructional.quiz.QuizPrompter;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson10 implements CommandLineRunner {
  @Autowired private QuizConfig quizConfig;

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson10.class);
    application.run(args);
  }

  public void run(String... args) {

    if (isJUnitTest()) {
      return;
    }

    System.out.println("\n");
    var scanner = new Scanner(System.in);

    try {
      // Randomize questions and choose first 15
      List<QuizQuestion> questions = quizConfig.getQuestions("default");
      Collections.shuffle(questions);
      questions = questions.subList(0, Math.min(questions.size(), 15));

      // Prompt for answers.
      var prompter = new QuizPrompter(scanner);
      prompter.promptForAnswers(questions);

      // Generate answers file in resources.
      String fileName = promptForFileName(scanner);
      saveAnswersToFile(questions, fileName);
    } finally {
      scanner.close();
    }
  }

  private String promptForFileName(Scanner scanner) {
    System.out.println();
    System.out.println("Quiz completed. Please provide a unique name for saving your answers.");

    String response = null;
    do {
      System.out.print(">> Your answer: ");
      response = scanner.next().toLowerCase().replaceAll("\\s+", "");
    } while (response.equals(""));

    return response;
  }

  private void saveAnswersToFile(List<QuizQuestion> questions, String filename) {
    var values = new LinkedHashMap<Integer, String>();
    for (QuizQuestion question : questions) {
      values.put(question.getQuestionNumber(), question.getAnswer());
    }

    var file = new File(getDataPath() + File.separator + filename + ".json");
    file.getParentFile().mkdirs();
    var gson = new GsonBuilder().setPrettyPrinting().create();

    try (var writer = new FileWriter(file, false)) {
      writer.write(gson.toJson(values));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getDataPath() {
    String[] pathParts = {
      Paths.get("").toAbsolutePath().toString(), "src", "main", "resources", "data"
    };
    return String.join(File.separator, pathParts);
  }

  private static boolean isJUnitTest() {
    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
      if (element.getClassName().startsWith("org.junit.")) {
        return true;
      }
    }
    return false;
  }
}
