package com.codedifferently.lesson10.library;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MediaItemTest {
  @Test
  public void testGetTitle() {
    UUID uuid = UUID.randomUUID();
    String expectedTitle =
        "Monster: The Autobiography of an L.A. Gang Member"; // Correct expected title
    MediaItem item =
        new Book(
            uuid,
            expectedTitle,
            List.of("Sanyika Shakur"), // Authors should be passed as a List
            1993,
            "978-0802141446"); // Create a Book object with the expected title
    String actualTitle = item.getTitle();
    Assertions.assertEquals(expectedTitle, actualTitle);
  }

  @Test
  public void testGetUUID() {
    UUID expectedUUID =
        UUID.fromString("e95721c2-c309-4cbc-92b2-e6b2119dbcb2"); // Correct expected UUID
    MediaItem item =
        new Book(
            expectedUUID,
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"), // Authors should be passed as a List
            1993,
            "978-0802141446"); // Create a Book object with the expected UUID
    UUID actualUUID = item.getUUID();
    Assertions.assertEquals(expectedUUID, actualUUID);
  }

  @Test
  void testGetType() {
    MediaItem mediaItem =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "978-0802141446");

    assertThat(mediaItem.getType()).isEqualTo("Book");
  }

  @Test
  void testCheckOut() {
    MediaItem mediaItem =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "978-0802141446");

    mediaItem.checkOut();
    assertThat(mediaItem.isCheckedOut()).isTrue();
  }

  @Test
  void testCheckIn() {
    MediaItem mediaItem =
        new Book(
            UUID.randomUUID(),
            "Monster: The Autobiography of an L.A. Gang Member",
            List.of("Sanyika Shakur"),
            1993,
            "978-0802141446");

    mediaItem.checkOut();
    mediaItem.checkIn();
    assertThat(mediaItem.isCheckedOut()).isFalse();
  }
}
