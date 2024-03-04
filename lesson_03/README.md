# Lesson 03

## Homework

1. Read CC 2,4; SEG 1 
1. Create your Codio account [using this link][codio-link].
1. Create three new quiz questions.
1. [Stretch] Write code for [8-bit assembler][assembler-link] that implements the substring function. It will take as input a string, a starting index, and an ending index. The function must print the substring portion indicated by the indices. Submit this portion of the assignment as a separate PR for my review for additional credit.

## Important reminders

* Make sure to sync your fork before creating a branch in order to pull in the latest changes.
* Sync your branch often to avoid merge conflicts and execute `git pull` to bring the latest changes to your machine.
* If your branch is too far behind or you run into too many issues, feel free to delete and re-create your repository. Make sure to review the article linked at the bottom of the [lesson_00](/lesson_00/README.md) README for instructions on how to create your fork and branch properly.
* Remember, you should not reuse a branch you've used to submit a pull request. If you need to make changes, create a new branch and work from there after you've updated your fork to the latest.

## Creating new quiz questions

Now's your chance to quiz the instructor! In this assignment, you will modify the quiz project to include two quiz questions based on the content you've learned in this course so far. Feel free to choose any topic for your questions.

1. You will create a quiz file in the [quizzes folder][quizzes-folder]. You should model yours after the example provided in [AnthonyMaysQuiz.java][quiz-example]. Note that the name of the file you create should match the name of the class in the file.
2. Make sure to provide a unique provider name for your questions provider. You'll need this name to provide answers in step 4.
```java
  public String getProviderName() {
    return "<your unique name goes here>";
  }
```
3. Make at least two questions for your quiz and _leave them unanswered_.
4. To provide answers, you will need to update the [application.yml][test-config-file] file in the test directory. You can copy the example in the file to get started, but you must provide your own answers. To generate an encrypted answer, use [bcrypt.online](https://bcrypt.online).
5. Before attempting to submit your quiz, make sure to run the formatter on the code and run the tests to ensure that you've updated things correctly. These commands must be run from the [quiz][quiz-folder] sub-folder just like the previous assignment:
```bash
./gradlew spotlessApply
./gradlew check
```
6. Once everything passes, submit a PR.

**Note: If you want to check that you've encoded your answers correctly, you can update you quiz with the real answers and then run the tests using the command below. 
```bash
./gradlew test -Dprofile=prod
```

[codio-link]: https://codio.com/p/signup?courseToken=vatican-flood
[assembler-link]: https://schweigi.github.io/assembler-simulator/
[quizzes-folder]: ./quiz/lesson_03_quiz/src/main/java/com/codedifferently/lesson3/quizzes/
[quiz-folder]: ./quiz/
[quiz-example]: ./quiz/lesson_03_quiz/src/main/java/com/codedifferently/lesson3/quizzes/AnthonyMaysQuiz.java
[test-config-file]: ./quiz/lesson_03_quiz/src/test/resources/application.yml
