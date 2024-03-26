package main.java.com.codedifferently.lesson10.library;


public class Magazine {
    private String title;
    private String publisher;
    private int numberOfPages; 
    private boolean checkedOut;

    // Constructor
    public Dvd(String title, String publisher, int numberOfPages) {
        this.title = title;
        this.director = publisher;
        this.duration = numberOfPages; 
        this.checkedOut = false; // By default, the magazine is not checked out
    }

    // Getter and setter methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter methods for publisher
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.director = publisher;
    }

    // Getter and setter methods for duration
    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.duration = numberOfPages;
    }

    // Method to check if the Magazine is checked out
    public boolean isCheckedOut() {
        return checkedOut;
    }

    // Method to set the checked out status of the Magazine
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    // Method to display information about the Magazine
    public void displayInfo() {
        System.out.println("Magazine Title: " + title);
        System.out.println("Publisher: " + publisher);
        System.out.println("NumberOfPages: " + numberOfPages);
        System.out.println("Checked Out: " + (checkedOut ? "Yes" : "No"));
    }
}
