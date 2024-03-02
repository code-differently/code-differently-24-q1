# Lesson 04

## Homework

1. Read CC 2,4; SEG 1 
1. Create three new quiz questions.

## Creating new quiz questions

In this assignment, you will modify a new project to include three quiz questions based on the content you've learned in this course so far. Feel free to choose any topic for your questions.

1. You will create a quiz file in the [quizzes folder][quizzes-folder]. You should model yours after the example provided in [AnthonyMaysQuiz.java][quiz-example].
2. Make sure to provide a unique provider name for your questions provider:
```java
  public String getProviderName() {
    return "<your unique name goes here>";
  }
```
3. Make at least two questions for your quiz.
4. To provide answers, you will need to update the [application.yaml][test-config-file] file in the test directory. You can copy the example in the file to get started, but you must provide your own answers. To generate an encrypted answer, use [bcrypt.online](https://bcrypt.online).


[quizzes-folder]: ./quiz/lesson_03_quiz/src/main/java/com/codedifferently/lesson3/quizzes/
[quiz-example]: ./quiz/lesson_03_quiz/src/main/java/com/codedifferently/lesson3/quizzes/AnthonyMaysQuiz.java
[test-config-file]: ./quiz/lesson_03_quiz/src/test/resources/application.yaml
