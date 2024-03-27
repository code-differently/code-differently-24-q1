package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class BookTest {

  @Test
  void testBookCreation() {
    // Arrange
    UUID uuid = UUID.randomUUID();
    String title = "To Kill a Mockingbird";
    List<String> authors = List.of("Harper Lee");
    int numberOfPages = 281;
    String isbn = "978-0061120084";

    // Act
    Book book = new Book(uuid, title, authors, numberOfPages, isbn);

    // Assert
    assertThat(book.getTitle()).isEqualTo(title);
    assertThat(book.getAuthors()).isEqualTo(authors);
    assertThat(book.getNumberOfPages()).isEqualTo(numberOfPages);
    assertThat(book.getIsbn()).isEqualTo(isbn);
    assertThat(book.getType()).isEqualTo("Book");
  }

  @Test
  void testToString() {
    // Arrange
    UUID uuid = UUID.randomUUID();
    String title = "To Kill a Mockingbird";
    List<String> authors = List.of("Harper Lee");
    int numberOfPages = 281;
    String isbn = "978-0061120084";
    Book book = new Book(uuid, title, authors, numberOfPages, isbn);

    // Act & Assert
    assertThat(book.toString()).contains(title, authors.toString(), String.valueOf(numberOfPages));
  }
}
