# Lesson 10

## Quiz Instructions

1. Sync your fork and create a new branch for your quiz.
2. Terminal into the `quiz` sub-directory and run the following command to take the quiz interactively:
```bash
./gradlew run --console=plain
```
3. If you would like to check your answers, you can run the following command:
```bash
./gradlew test -Dprofile=prod -DquizTaker={quiz file name}
```
4. Submit a PR with your response. Your last submission up to the cutoff deadline will be accepted (3/20/24 @ 1:20 PM ET).

## Homework

* Read HFDP 1-2.
* Complete [Applying SOLID principles](#applying-solid-principles-library-management-system-part-ii) exercise.

## Applying SOLID Principles (Library Management System, Part II)

In this assignment, you will be given starting implementations for the `Library`, `Book`, and `Patron` classes. You will need to add the following enhancements to support new functionality:

* We now want to support the concept of a `Librarian`. A librarian should be able to check out or check in items just like other patrons. Items can no longer be added or removed from the `Library` without a librarian.
* We also want to support other types of media formats, including `Dvd`, `Magazine`, and `Newspaper` types. Patrons cannot check out `Magazine` or `Newspaper` items.
* [Optional Stretch] Add the ability to search for items in the library by title, ISBN, author, or type. Extra credit will not be assigned unless the previous requirements have been met.
* [Optional Stretch] Add the ability for patrons to be members of multiple libraries. See previous note on extra credit.

You will need to make changes to code in the [solid/][solid-folder] sub-folder and submit your PR for credit. Don't forget to follow the Conventional Commit spec for your commit messages and pull requests title and descriptions.

[solid-folder]: ./solid/
