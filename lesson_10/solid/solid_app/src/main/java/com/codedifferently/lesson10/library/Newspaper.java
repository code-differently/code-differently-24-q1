package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.NewspaperCheckedOutException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;

public class Newspaper {
    private Library library;
    private String title;
    private int issn;

    public Newspaper(String title, int issn) {
        this.title = title;
        this.issn = issn;
    }

    public int getIssn() {
        return this.issn;
    }

    public Library getLibrary() {
        return library;
    }

    public boolean isNewspaperCheckedOut() throws NewspaperCheckedOutException {
      throw new NewspaperCheckedOutException(
          "Sorry! Newspaper cannot be checked out from the library.");
  }
    public void setLibrary(Library library) throws WrongLibraryException {
        if (library != null && !library.hasNewspaper(this)) {
            throw new WrongLibraryException(
                "Newspaper " + this.getIssn() + " is not in library " + library.getId());
        }
        this.library = library;
    }

    public String getTitle() {
        return title;
    }
  }
