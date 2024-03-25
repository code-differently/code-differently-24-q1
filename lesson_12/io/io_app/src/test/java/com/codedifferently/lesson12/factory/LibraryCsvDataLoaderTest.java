package com.codedifferently.lesson12.factory;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson12.Lesson12;
import com.codedifferently.lesson12.library.LibraryGuest;
import com.codedifferently.lesson12.library.MediaItem;
import com.codedifferently.lesson12.models.CheckoutModel;
import com.codedifferently.lesson12.models.LibraryDataModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = Lesson12.class)
class LibraryCsvDataLoaderTest {
  @Autowired private List<LibraryCsvDataLoader> libraryCsvDataLoaders;
  private final Map<String, LibraryDataModel> libraryDataModelByLoader = new HashMap<>();

  @BeforeAll
  void beforeAll() throws Exception {
    if (libraryCsvDataLoaders == null) {
      return;
    }
    for (LibraryCsvDataLoader loader : libraryCsvDataLoaders) {
      libraryDataModelByLoader.put(loader.getClass().getName(), loader.loadData());
    }
  }

  @Test
  void testDataLoader_loadsCheckedOutItems() {
    for (var entry : libraryDataModelByLoader.entrySet()) {
      String className = entry.getKey();
      LibraryDataModel libraryDataModel = entry.getValue();
      Map<String, List<CheckoutModel>> checkedOutItemsByGuest =
          libraryDataModel.getCheckoutsByEmail();
      var numCheckedOutItems = checkedOutItemsByGuest.values().stream().mapToInt(List::size).sum();
      assertThat(numCheckedOutItems)
          .describedAs("Loader %s should load checked out items", className)
          .isEqualTo(4);
    }
  }

  @Test
  void testDataLoader_loadsCorrectItemTypes() {
    for (var entry : libraryDataModelByLoader.entrySet()) {
      LibraryDataModel libraryDataModel = entry.getValue();
      List<MediaItem> items = libraryDataModel.getMediaItems();
      Map<String, Integer> countByMediaType =
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
      assertThat(countByMediaType.get("book")).isEqualTo(7);
      assertThat(countByMediaType.get("magazine")).isEqualTo(8);
      assertThat(countByMediaType.get("newspaper")).isEqualTo(8);
      assertThat(countByMediaType.get("dvd")).isEqualTo(8);
      assertThat(items.stream().map(MediaItem::getId).distinct().count()).isEqualTo(31);
      assertThat(items.stream().map(MediaItem::getTitle).distinct().count()).isEqualTo(31);
    }
  }

  @Test
  void testDataLoader_loadsCorrectGuestTypes() {
    for (var entry : libraryDataModelByLoader.entrySet()) {
      LibraryDataModel libraryDataModel = entry.getValue();
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
}
