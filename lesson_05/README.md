# Lesson 05

## Homework

* Read CC 14, 15
* Read article on [Conventional Commits][conventional-commits-link].
* Complete [data types exercise](#choosing-the-right-data-types).

## Choosing the Right Data Types

For this exercise, you will use your knowledge of data types to identify the appropriate type to store and process data. You will run a program to generate a unique file with sample data, then write code to provide the correct data type of each column.

1. Execute the Lesson 05 app providing a unique provider name.

```bash
./gradlew bootRun --args="yourprovidername" # Substitute with your own value
```
2. Examine the file that was created for you in the [resources/data][resources-folder] folder. The file will be formatted using the [JSON][json-link] data format.
3. Next, you will create a `DataProvider` implementation that will provide information about the data types for the columns in the file (e.g. `column1`, `column2`, etc.). You can view the example [AnthonyMaysProvider.java][example-file] file.
4. Customize the data types map by choosing the closest appropriate data type of each column. Each data type should only be used **once**.
5. As usual, make sure to apply the formatter and run the tests to confirm that you've implemented everything correctly.
6. You are to submit a PR with your `DataProvider` implementation and the generated `.json` file that was produced for you. All build checks must pass in order to receive full credit.
7. As an added requirement for this exercise, you should use [Conventional Commits][conventional-commits-link] going forward, both for your commits and for your PR titles. Poorly written titles and commit messages will be factored into your assessment.

[conventional-commits-link]: https://www.conventionalcommits.org/en/v1.0.0/
[json-link]: https://developer.mozilla.org/en-US/docs/Learn/JavaScript/Objects/JSON
[resources-folder]: ./types/types_app/src/main/resources/data/
[example-file]: ./types/types_app/src/main/java/com/codedifferently/lesson5/dataprovider/AnthonyMaysProvider.java
