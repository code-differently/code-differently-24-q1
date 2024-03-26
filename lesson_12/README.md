# Lesson 12

## Homework

* Read HFDP 3.
* Complete [Loading the Library](#loading-the-library) assignment.

## Loading The Library

We've got everything we need to manage our library except for one important thing—books! For this assignment, you will need:

* Create a unique folder created in the [factory/][factory-folder] directory.
* Provide a concrete implementation of the [LibraryCsvDataLoader][csv-data-loader] interface that loads data from CSV files in the app's [resources/csv][csv-resources] directory.
* You must also use the `org.springframework.stereotype.Service` annotation on your implementation (see [this example][example-service] back in Lesson 03) in order for it to be included in the tests. 

To run the app using the default [data loader][json-loader], use the following command (only supports search at the moment):

```java
./gradlew run --console=plain
```

To try out the app with your loader instead, you can run the following command. An example loader called `MyCsvLoader` in package `mypackage` is used for illustration purposes.

```java
./gradlew run --console=plain --args="--loader=com.codedifferently.lesson12.factory.mypackage.MyCsvLoader"
```

[csv-data-loader]: ./io/io_app/src/main/java/com/codedifferently/lesson12/factory/LibraryCsvDataLoader.java
[json-loader]: ./io/io_app/src/main/java/com/codedifferently/lesson12/factory/LibraryJsonDataLoader.java
[factory-folder]: ./io/io_app/src/main/java/com/codedifferently/lesson12/factory/
[csv-resources]: ./io/io_app/src/main/resources/csv/
[example-service]: /lesson_03/quiz/lesson_03_quiz/src/main/java/com/codedifferently/lesson3/quizzes/AnthonyMaysQuiz.java

