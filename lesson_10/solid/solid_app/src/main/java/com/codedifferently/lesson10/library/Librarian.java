package com.codedifferently.lesson10.library;

import java.util.Objects;
import java.util.Set;

import com.codedifferently.lesson10.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson10.library.exceptions.WrongLibraryException;


  public class Librarian {

    private String name;
    private int empId;
    private Library library;

    public Librarian(String name, int empId) {
        this.name = name;
        this.empId = empId;
    }

    public void setLibrary(Library library) throws WrongLibraryException {
        if (library != null && !library.hasLibrarian(this)) {
            throw new WrongLibraryException(
                "Librarian " + this.getEmpId() + " is not in library " + library.getId());
        }
        this.library = library;
    }

    public String getName() {
        return this.name;
    }

    public int getEmpId() {
        return this.empId;
    }

    public Set<Book> getCheckedOutBooks() throws LibraryNotSetException {
        if (this.library == null) {
            throw new LibraryNotSetException("Library not set for Librarian " + this.getEmpId());
        }
        return this.library.getCheckedOutByLibrarian(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Librarian)) return false;
        Librarian librarian = (Librarian) o;
        return getEmpId() == librarian.getEmpId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId());
    }

    @Override
    public String toString() {
        return "Librarian{" + "empId='" + getEmpId() + '\'' + ", name='" + getName() + '\'' + '}';
    }
}

