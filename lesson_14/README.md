# Lesson 14

## Homework

* Memorize the `printPermutations` and `reverseString` methods in [algos_app][algos-app].
* [Extra credit] Complete [Loading the Library, Part II](#loading-the-library-part-ii) assignment.

## Loading The Library, Part II

Instead of loading our library data from JSON or CSV files, we now want to load data from a proper database. A new implementation of the `LibraryDbDataLoader` data loader has been provided to accomplish this task and is now the [default data loader][library-app] for the app.

To build familiarity in working with databases, you are charged with the following tasks:

* Write a `.sql` script file that queries the following data. Use a unique name for your file and store it in the [queries][queries-dir] directory of the resources folder.
    * A `SELECT` query that returns the counts of media items by type.
    * A `SELECT` query that returns the sum of total pages checked out by guests.
    * A `SELECT` query that shows all 5 guests and any corresponding records in the `checked_out_items` table.
* Add a new table called `library_users` to the SQLite database that stores a user's id (UUID formatted string), email, first name, last name, and a password (bcrypt encoded string). Add a model and repository that loads the users into the LibraryDataModel. Populate the database with a few users.

As before, you can run the app from the console using the following command:

```bash
./gradlew run --console=plain
```

[algos-app]: ./algos/algos_app/src/main/java/com/codedifferently/lesson14/Lesson14.java
[queries-dir]: ./db/db_app/src/main/resources/queries/
[library-app]: ./db/db_app/src/main/java/com/codedifferently/lesson14/cli/LibraryApp.java#L26
