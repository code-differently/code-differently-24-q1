# Lesson 09

## Homework

* Read [PIE][pie-book] 8; TPP 2.8–2.10
* Read this [article on Test-Driven Development][tdd-article].
* Complete [Library Management System](#library-management-system) assignment.

## Library Management System

For this assignment, you will build a library management system using object oriented principles. Pay attention to the requirements careful in order to implement your system successfully.

### Functional Requirements

* We want to define a book and keep track of its title, isbn, author(s), number of pages, and whether it is checked out or not.
* We want define a patron with properties including their name and the books they have checked out.
* We want to define a library that:
    * Allows us to add/remove a book to and from its collection of books. 
    * Allows us to register new patrons
    * Allows us to check out books to patrons.
    * Allows us to return books from patrons.

### Technical Requirements

* All of your types must be created in a unique sub-package under the `com.codedifferently.lesson9` namespace.
* Include tests for all of your classes and public methods.
* Include appropriate `javadoc` for your classes and methods. In VS Code, you can usually start a comment with `/**` and press `Enter` to let the IDE automatically create some starter text for you.

### Tips

* Read the functional requirements carefully, and take special care to identify *objects*, their *data*, and their *actions*.
* It is highly recommended that you write your tests firsts, and then build what you need to make the tests work. This is essential to [Test-Driven Development][tdd-article].

[pie-book]: https://github.com/shshankar1/ebooks/blob/master/Programming%20Interviews%20Exposed.PDF
[tdd-article]: https://semaphoreci.com/blog/test-driven-development
