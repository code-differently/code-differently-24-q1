package main.java.com.codedifferently.lesson10.library;

public class Newspaper extends MediaItem {
    // Additional properties specific to newspapers
    private String publisher;
    private String publicationDate;

    // Constructor
    public Newspaper(String title, String publisher, String publicationDate) {
        super(title);
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    // Getter and setter methods for publisher
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Getter and setter methods for publication date
    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }    
// Method to display information about the newspaper
@Override
public void displayInfo() {
    System.out.println("Newspaper Title: " + getTitle());
    System.out.println("Publisher: " + publisher);
    System.out.println("Publication Date: " + publicationDate);
    System.out.println("Checked Out: " + (isCheckedOut() ? "Yes" : "No"));
}
}

