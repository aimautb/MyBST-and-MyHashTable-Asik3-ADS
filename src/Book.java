/**
 * A class representing a book with a title and publication year.
 */
public class Book {
    private String title;
    private int year;

    /**
     * Constructor to initialize the book's title and publication year.
     *
     * @param title the title of the book
     * @param year  the year the book was published
     */
    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    /**
     * Overriding toString to provide a readable string representation of the book.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return "Book{" + "title='" + title + "', year=" + year + "}";
    }
}