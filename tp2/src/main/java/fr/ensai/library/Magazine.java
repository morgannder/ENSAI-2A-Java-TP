package fr.ensai.library;

/**
 * Represents a book.
 */
public class Magazine {

    // Attributes
    private String issn;
    private String title;
    private int issueNumber;
    private int year;
    private int pageCount;

    /**
     * Constructs a new Magazine object.
     */
    public Magazine(String issn, String title, int issueNumber, int year, int pageCount) {
        this.issn = issn;
        this.title = title;
        this.issueNumber = issueNumber;
        this.year = year;
        this.pageCount = pageCount;
    }

}
