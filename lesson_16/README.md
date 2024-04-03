# Lesson 16

## Homework

* Complete the [Creating the Library API](#create-the-books-api) exercise.

## Creating the Library API

We are continuing to build atop the foundation of our library app. For this assignment, you will help implement the API that will be used by a yet-to-come front-end app.

* You will implement the [MediaItemsController][controller-file] to enable the following API:
   * `GET /items` - Retrieves a list of media items
   * `POST /items` - Creates a new media item
   * `GET /items/:id` - Retrieves a single media item with the given ID.
   * `DELETE /items/:id` - Deletes a single media item with the given ID.
* You will also implement a new `PatronsController` that will allow the following interactions:
   * `GET /patrons` - Retrieves a list of patrons.
   * `POST /patrons` - Creates a new patron.
   * `GET /patrons/:id` - Retrieves a single patron with the given ID.
   * `DELETE /patrons/:id` - Deletes a single patron with the given ID.
* Study the tests in [MediaItemsControllerTest][controller-test-file] to understand what you should accept and return in the API.
* You should not need to make any code changes outside of the `com.codedifferently.lesson16.web` package.

## Running the API

You can run the server using the usual `./gradlew run` command. If you want to test that the server is running correctly, you can use `curl` like so:

```bash
curl http://localhost:5000/items | json_pp
```

Alternatively, you can test the API using the tool [Postman][postman-link]. I recommend installing this tool to make it easier to test things.

## Additional Resources

* [What are HTTP requests?](https://youtu.be/-Zea7GB2OwA)
* [Build a REST API with Spring and Java Config](https://www.baeldung.com/building-a-restful-web-service-with-spring-and-java-based-configuration)
* [Exploring REST APIs with Spring MVC](https://www.developer.com/java/exploring-rest-apis-with-spring-mvc/)
* [Using Lombok’s @Builder Annotation](https://www.baeldung.com/lombok-builder)
* [Validation in Spring Boot](https://www.baeldung.com/spring-boot-bean-validation)

[controller-file]: ./api//api_app/src/main/java/com/codedifferently/lesson16/web/MediaItemsController.java
[controller-test-file]: ./api/api_app/src/test/java/com/codedifferently/lesson16/web/MediaItemsControllerTest.java
[postman-link]: https://postman.com