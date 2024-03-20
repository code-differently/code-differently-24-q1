package com.codedifferently.quiz.lesson10;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.instructional.quiz.MultipleChoiceQuizQuestion;
import com.codedifferently.instructional.quiz.QuizConfig;
import com.codedifferently.instructional.quiz.QuizQuestion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.EnabledIf;

@SpringBootTest
@ContextConfiguration(classes = Lesson10.class)
class Lesson10Test {
  @Autowired private QuizConfig quizConfig;

  @Test
  void testQuiz_questionConfigured() {
    // Arrange
    var questions = quizConfig.getQuestions("default");

    // Assert
    assertThat(questions.size()).isGreaterThanOrEqualTo(15);
    for (QuizQuestion question : questions) {
      assertThat(question).isInstanceOf(MultipleChoiceQuizQuestion.class);
      var multipleChoiceQuestion = (MultipleChoiceQuizQuestion) question;
      assertThat(multipleChoiceQuestion.getAnswerChoices().size()).isEqualTo(4);
    }
  }

  @Test
  @EnabledIf(value = "#{environment.getActiveProfiles()[0] == 'prod'}", loadContext = true)
  void checkQuestions_answeredCorrectly() throws Exception {
    List<Path> paths = getResponseFilePaths();
    for (Path path : paths) {
      Map<Integer, String> responses = getResponsesFromPath(path);
      for (var entry : responses.entrySet()) {
        Integer questionNumber = entry.getKey();
        String response = entry.getValue();
        boolean result = quizConfig.checkAnswer("default", questionNumber, response);
        assertThat(result).isEqualTo(true);
      }
    }
  }

  private static List<Path> getResponseFilePaths() {
    var result = new ArrayList<Path>();

    Path dirPath = Paths.get(Lesson10.getDataPath());
    try (Stream<Path> paths = Files.walk(dirPath)) {
      paths.forEach(
          filePath -> {
            if (!Files.isRegularFile(filePath)) {
              return;
            }
            result.add(filePath);
          });
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }

  private static Map<Integer, String> getResponsesFromPath(Path filePath) throws Exception {
    var gson = new Gson();
    try (var reader = new InputStreamReader(Files.newInputStream(filePath))) {
      var typeToken = new TypeToken<Map<Integer, String>>() {}.getType();
      return gson.fromJson(reader, typeToken);
    } catch (IOException e) {
      throw new Exception(e);
    }
  }
}
