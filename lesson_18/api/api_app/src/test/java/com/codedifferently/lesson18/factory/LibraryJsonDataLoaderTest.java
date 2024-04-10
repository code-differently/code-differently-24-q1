package com.codedifferently.lesson18.factory;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson18.library.LibraryGuest;
import com.codedifferently.lesson18.library.MediaItem;
import com.codedifferently.lesson18.library.MediaType;
import com.codedifferently.lesson18.models.CheckoutModel;
import com.codedifferently.lesson18.models.LibraryDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LibraryJsonDataLoaderTest {
  private static LibraryDataModel libraryDataModel;

  @BeforeAll
  static void beforeAll() throws Exception {
    var libraryJsonDataLoader = new LibraryJsonDataLoader();
    libraryDataModel = libraryJsonDataLoader.loadData();
  }

  @Test
  void testDataLoader_loadsCheckedOutItems() {
    Map<String, List<CheckoutModel>> checkedOutItemsByGuest =
        libraryDataModel.getCheckoutsByEmail();
    var numCheckedOutItems = checkedOutItemsByGuest.values().stream().mapToInt(List::size).sum();
    assertThat(numCheckedOutItems).isEqualTo(4);
  }

  @Test
  void testDataLoader_loadsCorrectItemTypes() {
    List<MediaItem> items = libraryDataModel.getMediaItems();
    Map<MediaType, Integer> countByMediaType =
        items.stream()
            .reduce(
                new HashMap<>(),
                (hashMap, e) -> {
                  hashMap.merge(e.getType(), 1, Integer::sum);
                  return hashMap;
                },
                (m, m2) -> {
                  m.putAll(m2);
                  return m;
                });
    assertThat(countByMediaType.get(MediaType.BOOK)).isEqualTo(7);
    assertThat(countByMediaType.get(MediaType.MAGAZINE)).isEqualTo(8);
    assertThat(countByMediaType.get(MediaType.NEWSPAPER)).isEqualTo(8);
    assertThat(countByMediaType.get(MediaType.DVD)).isEqualTo(8);
    assertThat(items.stream().map(MediaItem::getId).distinct().count()).isEqualTo(31);
    assertThat(items.stream().map(MediaItem::getTitle).distinct().count()).isEqualTo(31);
  }

  @Test
  void testDataLoader_loadsCorrectGuestTypes() {
    List<LibraryGuest> guests = libraryDataModel.getGuests();
    Map<String, Integer> countByGuestType =
        guests.stream()
            .reduce(
                new HashMap<>(),
                (hashMap, e) -> {
                  hashMap.merge(e.getClass().getSimpleName(), 1, Integer::sum);
                  return hashMap;
                },
                (m, m2) -> {
                  m.putAll(m2);
                  return m;
                });
    assertThat(countByGuestType.get("Librarian")).isEqualTo(2);
    assertThat(countByGuestType.get("Patron")).isEqualTo(3);
    assertThat(guests.stream().map(LibraryGuest::getEmail).distinct().count()).isEqualTo(5);
    assertThat(guests.stream().map(LibraryGuest::getName).distinct().count()).isEqualTo(5);
  }
}
