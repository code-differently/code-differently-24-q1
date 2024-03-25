package main.java.com.codedifferently.lesson10.library;


public class Dvd {
    private String title;
    private String director;
    private int duration; // Duration in minutes
    private boolean checkedOut;

    // Constructor
    public Dvd(String title, String director, int duration) {
        this.title = title;
        this.director = director;
        this.duration = duration;
        this.checkedOut = false; // By default, the DVD is not checked out
    }

    // Getter and setter methods for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and setter methods for director
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Getter and setter methods for duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Method to check if the DVD is checked out
    public boolean isCheckedOut() {
        return checkedOut;
    }

    // Method to set the checked out status of the DVD
    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    // Method to display information about the DVD
    public void displayInfo() {
        System.out.println("DVd Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Checked Out: " + (checkedOut ? "Yes" : "No"));
    }
}
