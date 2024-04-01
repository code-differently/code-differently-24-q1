package com.codedifferently.lesson14.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson14.Lesson14;
import com.codedifferently.lesson14.models.LibraryUserModel;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = Lesson14.class)
@Transactional
public class LibraryUserServiceTest {

  @Autowired LibraryUserService libraryUserService;

  @Test
  void addUserTest() {
    LibraryUserModel libraryUserModel = new LibraryUserModel();
    libraryUserModel.email = "vicente@example.com";
    libraryUserModel.firstName = "vicente";
    libraryUserModel.lastName = "vigueras";
    libraryUserModel.password = "password123";
    libraryUserModel.userID = UUID.randomUUID();
    libraryUserService.addUser(libraryUserModel);
  }

  @Test
  void addUserWithPrimaryKeyOnly() {
    LibraryUserModel libraryUserModel = new LibraryUserModel();
    libraryUserModel.userID = UUID.randomUUID();
    libraryUserService.addUser(libraryUserModel);
  }

  @Test
  void addUserWithoutPrimaryKey() {

    Exception exception =
        assertThrows(
            Exception.class,
            () -> {
              LibraryUserModel libraryUserModel = new LibraryUserModel();
              libraryUserService.addUser(libraryUserModel);
            });
    Assertions.assertEquals(
        "Identifier of entity 'com.codedifferently.lesson14.models.LibraryUserModel' must be manually assigned before calling 'persist()'",
        exception.getMessage());
  }

  @Test
  void retrieveUsers() {
    Iterable<LibraryUserModel> users = libraryUserService.findAllUsers();
  }
}
