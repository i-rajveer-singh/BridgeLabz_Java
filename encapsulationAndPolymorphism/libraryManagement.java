package fourpillars;

/*
 * UniqueLibrarySphere models a library system using abstraction,
 * encapsulation, interfaces, and polymorphism. It manages different
 * library items, controls reservations, and secures borrower data.
 */

import java.util.*;

// Interface defining reservation behavior
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class representing a generic library item
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;
    private String borrowerName; // Sensitive borrower data
    private boolean isReserved;

    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isReserved = false;
    }

    // Forces subclasses to define loan duration
    public abstract int getLoanDuration();

    // Displays item info without exposing borrower data
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration (days): " + getLoanDuration());
        System.out.println("Available: " + (!isReserved));
        System.out.println("----------------------");
    }

    // Internal methods protect borrower information
    protected void setBorrower(String borrowerName) {
        this.borrowerName = borrowerName;
        this.isReserved = true;
    }

    protected boolean isReserved() {
        return isReserved;
    }

    protected void clearReservation() {
        this.borrowerName = null;
        this.isReserved = false;
    }
}

// Book with standard loan period
class Book extends LibraryItem implements Reservable {

    public Book(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved()) { // Prevent double reservation
            setBorrower(borrowerName);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// Magazine with shorter loan duration
class Magazine extends LibraryItem implements Reservable {

    public Magazine(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// DVD with minimal loan duration
class DVD extends LibraryItem implements Reservable {

    public DVD(int id, String title, String author) {
        super(id, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // Short-term issue
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// Unique main class name to avoid conflicts
public class LibrarySphere {
    public static void main(String[] args) {

        // Polymorphism: storing different item types in LibraryItem reference
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book(1, "Clean Code", "Robert Martin"));
        items.add(new Magazine(2, "National Geographic", "Various"));
        items.add(new DVD(3, "Inception", "Christopher Nolan"));

        // Managing all items through common reference
        for (LibraryItem item : items) {
            item.getItemDetails();
        }

        // Demonstrating reservation via interface
        Reservable reservableBook = (Reservable) items.get(0);
        reservableBook.reserveItem("Aaditya");

        System.out.println("Availability after reservation: " + reservableBook.checkAvailability());
    }
}

