package com.codedifferently.lesson10.library;

import com.codedifferently.lesson10.library.exceptions.MagazineCheckedOutException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;
import java.util.Objects;

public class Magazine {
  private Library library;
  private String title;
  private int issn;

  public Magazine(String title, int issn) {
    this.title = title;
    this.issn = issn;
  }

  public int getIssn() {
    return this.issn;
  }

  public Library getLibrary() {
    return library;
  }

  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasMagazine(this)) {
      throw new WrongLibraryException(
          "Magazine " + this.getIssn() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  public String getTitle() {
    return title;
  }

  public boolean isMagazineCheckedOut() throws MagazineCheckedOutException {
    throw new MagazineCheckedOutException(
        "Sorry! Magazine cannot be checked out from the library.");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Magazine)) return false;
    Magazine magazine = (Magazine) o;
    return issn == magazine.issn;
  }

  @Override
  public int hashCode() {
    return Objects.hash(issn);
  }

  @Override
  public String toString() {
    return "Magazine{" + "issn='" + issn + '\'' + ", title='" + title + '\'' + '}';
  }
}
