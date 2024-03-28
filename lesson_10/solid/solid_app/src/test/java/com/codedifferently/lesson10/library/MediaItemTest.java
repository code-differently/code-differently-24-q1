package com.codedifferently.lesson10.library;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MediaItemTest {
  private Library library;

  @BeforeEach
  public void setUp() {
    library = new Library("Library 1");
  }

  @Test
  public void testSetLibrary() {
    MediaItem mediaItem = new MockMediaItem();
    assertThrows(WrongLibraryException.class, () -> mediaItem.setLibrary(library));
  }

  @Test
  public void testIsCheckedOut() {
    MediaItem mediaItem = new MockMediaItem();
    assertThrows(LibraryNotSetException.class, () -> mediaItem.isCheckedOut());
  }

  private static class MockMediaItem extends MediaItem {
    @Override
    boolean canCheckOut() {
      return true; // Override for testing purposes
    }

    @Override
    public UUID getId() {
      return UUID.randomUUID(); // Override for testing purposes
    }
  }
}
