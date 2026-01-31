package Level1;

import java.util.Scanner;

/*
 * This class represents a simple library book system.
 * It uses a parameterized constructor and Scanner input
 * to manage book details and borrowing logic.
 */

class LibraryBook {

    private String title;
    private String author;
    private double price;
    private boolean available = true;

    // Initializes book details using constructor
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Handles book borrowing logic
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed");
        } else {
            System.out.println("Book not available");
        }
    }

    // Displays book details and availability status
    void display() {
        System.out.println(title + " | " + author + " | " + price + " | Available: " + available);
    }

    // Main method to take input and test borrow system
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Title: ");
        String t = sc.nextLine();
        System.out.print("Author: ");
        String a = sc.nextLine();
        System.out.print("Price: ");
        double p = sc.nextDouble();

        LibraryBook b = new LibraryBook(t, a, p);
        b.display();
        b.borrowBook();
        b.display();
    }
}
