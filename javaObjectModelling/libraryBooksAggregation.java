package objectmodelling;

import java.util.ArrayList;

/*
 * This program demonstrates Aggregation in Object Modeling.
 * Library aggregates Book objects without owning their lifecycle.
 * Books can exist independently and can be shared across libraries.
 * This represents a weak "has-a" relationship.
 */

class Book {
    private String title;
    private String author;

    // Initializes book details
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Displays book information
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    private String libraryName;
    private ArrayList<Book> books;

    // Initializes library object
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    // Adds a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Displays all books in the library
    public void showBooks() {
        System.out.println("\nBooks in " + libraryName + ":");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

public class LibraryAggregation {
    public static void main(String[] args) {

        Book b1 = new Book("Clean Code", "Robert C. Martin");
        Book b2 = new Book("Effective Java", "Joshua Bloch");
        Book b3 = new Book("Design Patterns", "GoF");

        Library lib1 = new Library("SRM Central Library");
        Library lib2 = new Library("City Public Library");

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        lib1.showBooks();
        lib2.showBooks();
    }
}

