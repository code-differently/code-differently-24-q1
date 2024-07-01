# Lesson 02

## Homework

1. Read CODE 26-27
1. Complete Lesson 02 quiz

## Prerequisites

To complete this assignment, you must have **Docker** and **VS Code** with the [**Dev Containers**][dev-containers-link] extension installed.

## Lesson 02 Quiz Instructions

For this assignment, you will complete a quiz by modifying a Java application. Within the quiz project, there are tests that you will need to make pass in order to submit your answers. Here are the instructions for completing the assignment:

1. Make sure to sync your fork to pull in the latest changes.
2. Open the project in **VS Code** and make sure to select `Reopen in Container` when prompted.
3. Open the [Lesson2.java][lesson-2-quiz] file located in the [quiz/lesson_02_quiz/src/main/java/com/codedifferently/lesson_02_quiz/][lesson-2-dir] directory.
4. Update the code to provide the correct answers to the given questions.
5. This project uses a tool called [Spotless][spotless-link] to check that the code is formatted correctly. Once you are done with your changes, you can automatically fix formatting issues using the following command in the `quiz` sub-directory using the terminal:
```bash
./gradlew spotlessApply
```
6. When ready to test, run the following command in the `quiz` sub-directory using the terminal:
```bash
./gradlew check
```
7. Once all tests pass, submit your work by creating a pull request (PR).


[dev-containers-link]: https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers
[lesson-2-quiz]: quiz/lesson_02_quiz/src/main/java/com/codedifferently/lesson2/Lesson2.java
[lesson-2-dir]: quiz/lesson_02_quiz/src/main/java/com/codedifferently/lesson2/
[test-report]: quiz/lesson_02_quiz/build/reports/tests/test/index.html
[spotless-link]: https://github.com/diffplug/spotless
