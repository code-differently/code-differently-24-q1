package com.codedifferently.lesson12.library;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.codedifferently.lesson12.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson12.library.exceptions.WrongLibraryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MediaItemBaseTest {
  private MediaItemBase mediaItem;

  class MockMediaItem extends MediaItemBase {
    public MockMediaItem(String id, String title) {
      super(id, title);
    }
  }

  @BeforeEach
  void setUp() {
    mediaItem = new MockMediaItem("123", "Sample Title");
  }

  @Test
  void getId() {
    assertEquals("123", mediaItem.getId());
  }

  @Test
  void getTitle() {
    assertEquals("Sample Title", mediaItem.getTitle());
  }

  @Test
  void setLibrary_withWrongLibraryException() {
    Library library = mock(Library.class);
    when(library.getId()).thenReturn("compton-library");
    when(library.hasMediaItem(mediaItem)).thenReturn(false);
    assertThatThrownBy(() -> mediaItem.setLibrary(library))
        .isInstanceOf(WrongLibraryException.class)
        .hasMessage("Media item 123 is not in library compton-library");
  }

  @Test
  void isCheckedOut() throws LibraryNotSetException {
    Library library = mock(Library.class);
    when(library.hasMediaItem(mediaItem)).thenReturn(true);
    when(library.isCheckedOut(mediaItem)).thenReturn(true);
    mediaItem.setLibrary(library);
    assertTrue(mediaItem.isCheckedOut());
  }

  @Test
  void isCheckedOut_withLibraryNotSetException() {
    assertThatThrownBy(() -> mediaItem.isCheckedOut())
        .isInstanceOf(LibraryNotSetException.class)
        .hasMessage("Library not set for item 123");
  }

  @Test
  void canCheckOut() {
    assertTrue(mediaItem.canCheckOut());
  }

  @Test
  void equals() {
    MediaItemBase mediaItem2 = new MockMediaItem("123", "Sample Title");
    assertEquals(mediaItem, mediaItem2);
  }

  @Test
  void hashCodeTest() {
    MediaItemBase mediaItem2 = new MockMediaItem("123", "Sample Title");
    assertEquals(mediaItem.hashCode(), mediaItem2.hashCode());
  }

  @Test
  void toStringTest() {
    String expected = "MediaItem{id='123', title='Sample Title'}";
    assertEquals(expected, mediaItem.toString());
  }
}
