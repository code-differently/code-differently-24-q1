package com.codedifferently.lesson12;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.codedifferently.lesson12.cli.LibraryCommand;
import com.codedifferently.lesson12.cli.LibrarySearchCommand;
import com.codedifferently.lesson12.factory.LibraryDataLoader;
import com.codedifferently.lesson12.factory.LibraryFactory;
import com.codedifferently.lesson12.factory.LibraryJsonDataLoader;
import com.codedifferently.lesson12.library.Book;
import com.codedifferently.lesson12.library.Library;
import com.codedifferently.lesson12.library.LibraryInfo;
import com.codedifferently.lesson12.library.MediaItem;
import com.codedifferently.lesson12.library.search.SearchCriteria;

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
    System.out.println("========================================");
    System.out.println();

    try (var scanner = new Scanner(System.in)) {
      LibraryCommand command;
      while ((command = promptForCommand(scanner)) != LibraryCommand.EXIT) {
        switch (command) {
          case SEARCH -> doSearch(scanner, library);
          default -> System.out.println("\nNot ready yet, coming soon!");
        }
      }
    }
  }

  private static LibraryCommand promptForCommand(Scanner scanner) {
    var command = LibraryCommand.UNKNOWN;
    while (command == LibraryCommand.UNKNOWN) {
      printMenu();
      var input = scanner.nextLine();
      try {
        command = LibraryCommand.fromValue(Integer.parseInt(input.trim()));
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid command: " + input);
      }
    }
    return command;
  }

  private static void printMenu() {
    System.out.println("\nEnter the number of the desired command:");
    System.out.println("1) << EXIT");
    System.out.println("2) SEARCH");
    System.out.println("3) CHECKOUT");
    System.out.println("4) RETURN");
    System.out.print("command> ");
  }

  private void doSearch(Scanner scanner, Library library) {
    LibrarySearchCommand command = promptForSearchCommand(scanner);
    if (command == LibrarySearchCommand.RETURN) {
      return;
    }
    SearchCriteria criteria = getSearchCriteria(scanner, command);
    Set<MediaItem> results = library.search(criteria);
    printSearchResults(results);
  }

  private LibrarySearchCommand promptForSearchCommand(Scanner scanner) {
    var command = LibrarySearchCommand.UNKNOWN;
    while (command == LibrarySearchCommand.UNKNOWN) {
      printSearchMenu();
      var input = scanner.nextLine();
      try {
        command = LibrarySearchCommand.fromValue(Integer.parseInt(input.trim()));
      } catch (IllegalArgumentException e) {
        System.out.println("Invalid command: " + input);
      }
    }
    return command;
  }

  private void printSearchMenu() {
    System.out.println("\nEnter the number of the desired search criteria:");
    System.out.println("1) << RETURN");
    System.out.println("2) TITLE");
    System.out.println("3) AUTHOR");
    System.out.println("4) TYPE");
    System.out.print("search> ");
  }

  private SearchCriteria getSearchCriteria(Scanner scanner, LibrarySearchCommand command) {
    System.out.println();
    switch (command) {
      case TITLE -> {
        System.out.println("Enter the title to search for: ");
        System.out.print("title> ");
        var title = scanner.nextLine();
        return SearchCriteria.builder().title(title).build();
      }
      case AUTHOR -> {
        System.out.println("Enter the author to search for: ");
        System.out.print("author> ");
        var author = scanner.nextLine();
        return SearchCriteria.builder().author(author).build();
      }
      case TYPE -> {
        System.out.println("Enter the type to search for: ");
        System.out.print("type> ");
        var type = scanner.nextLine();
        return SearchCriteria.builder().type(type).build();
      }
      default -> System.out.println("Invalid search command: " + command);
    }
    return null;
  }

  private void printSearchResults(Set<MediaItem> results) {
    System.out.println();

    if (results.isEmpty()) {
      System.out.println("No results found.");
      return;
    }

    System.out.println("Search results:\n");
    for (MediaItem item : results) {
      System.out.println("ID: " + item.getId());
      System.out.println("TITLE: " + item.getTitle());
      if (item instanceof Book book) {
        System.out.println("AUTHOR(S): " + String.join(", ", book.getAuthors()));
      }
      System.out.println("TYPE: " + item.getType().toUpperCase());
      System.out.println();
    }
  }
}
