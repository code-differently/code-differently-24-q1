package com.codedifferently.lesson12;

import com.codedifferently.lesson12.factory.LibraryDataLoader;
import com.codedifferently.lesson12.factory.LibraryFactory;
import com.codedifferently.lesson12.factory.LibraryJsonDataLoader;
import com.codedifferently.lesson12.library.Library;
import com.codedifferently.lesson12.library.LibraryInfo;
import com.codedifferently.lesson12.library.MediaItem;
import com.codedifferently.lesson12.library.search.SearchCriteria;
import java.util.Map;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(scanBasePackages = "com.codedifferently")
public class Lesson12 implements CommandLineRunner {

  public static void main(String[] args) {
    var application = new SpringApplication(Lesson12.class);
    application.run(args);
  }

  @Override
  public void run(String... args) throws Exception {
    LibraryDataLoader loader = new LibraryJsonDataLoader();
    Library library = LibraryFactory.createWithLoader(loader);

    LibraryInfo info = library.getInfo();
    Map<String, Set<MediaItem>> checkedOutItemsByGuest = info.getCheckedOutItemsByGuest();
    var numCheckedOutItems = checkedOutItemsByGuest.values().stream().mapToInt(Set::size).sum();
    System.out.println();
    System.out.println("========================================");
    System.out.println("Library id: " + library.getId());
    System.out.println("Number of items: " + info.getItems().size());
    System.out.println("Number of guests: " + info.getGuests().size());
    System.out.println("Number of checked out items: " + numCheckedOutItems);

    var results = library.search(SearchCriteria.builder().author("J").build());
    System.out.println("Search results for 'Mockingbird': " + results.size());
  }
}
