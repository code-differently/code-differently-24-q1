package main.java.com.codedifferently.lesson10.library;

// MediaItem superclass
abstract class MediaItem {
    private boolean checkedOut;

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }
}

// Book Class (subclass of MediaItem)
class Book extends MediaItem {
    // Properties specific to books
}

// Dvd Class (subclass of MediaItem)
class Dvd extends MediaItem {
    // Properties specific to DVDs
}

// Magazine Class (subclass of MediaItem)
class Magazine extends MediaItem {
    // Properties specific to magazines
}

// Newspaper Class (subclass of MediaItem)
class Newspaper extends MediaItem {
    // Properties specific to newspapers
}
