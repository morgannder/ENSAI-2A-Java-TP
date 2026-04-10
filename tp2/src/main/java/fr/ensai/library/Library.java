package fr.ensai.library;

import java.util.ArrayList;
import java.util.List;

public class Library {

    // -------------------------------------------------------
    // Attributes
    // -------------------------------------------------------
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }
    // -------------------------------------------------------
    // Methods
    // -------------------------------------------------------

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println(("pas de bouquins dans la librairie"));
        }
    }

}
