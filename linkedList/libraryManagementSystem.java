package linkedlist;

/*
 * LibraryDoublyLinkedList manages books using a doubly linked list.
 * Supports insertion, deletion, searching, updating availability,
 * forward/reverse traversal, and counting total books.
 */

import java.util.Scanner;

// Node class representing each book
class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean available;
    Book next; // pointer to next node
    Book prev; // pointer to previous node

    Book(String title, String author, String genre, int bookId, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.available = available;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class
class LibraryDoublyLinkedList {

    private Book head; // start of list
    private Book tail; // end of list

    // Add book at beginning
    public void addAtBeginning(String title, String author, String genre, int id, boolean available) {

        Book newBook = new Book(title, author, genre, id, available);

        if (head == null) { // handles empty list
            head = tail = newBook;
        } else {
            newBook.next = head; // forward link
            head.prev = newBook; // backward link
            head = newBook; // shift head
        }

        System.out.println("Book added at beginning.");
    }

    // Add book at end
    public void addAtEnd(String title, String author, String genre, int id, boolean available) {

        Book newBook = new Book(title, author, genre, id, available);

        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook; // attach at end
            newBook.prev = tail;
            tail = newBook; // move tail
        }

        System.out.println("Book added at end.");
    }

    // Add book at position
    public void addAtPosition(int pos, String title, String author, String genre, int id, boolean available) {

        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }

        Book temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next; // move to node before position
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        if (temp.next == null) { // inserting at last
            addAtEnd(title, author, genre, id, available);
            return;
        }

        Book newBook = new Book(title, author, genre, id, available);

        newBook.next = temp.next;
        newBook.prev = temp;

        temp.next.prev = newBook; // fix backward chain
        temp.next = newBook;

        System.out.println("Book added at position " + pos);
    }

    // Remove book by ID
    public void removeById(int id) {

        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        Book temp = head;

        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }

        if (temp == head) { // deleting first node
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null; // list became empty
        }
        else if (temp == tail) { // deleting last node
            tail = tail.prev;
            tail.next = null;
        }
        else {
            temp.prev.next = temp.next; // bypass forward
            temp.next.prev = temp.prev; // bypass backward
        }

        System.out.println("Book removed.");
    }

    // Search by title
    public void searchByTitle(String title) {

        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Search by author
    public void searchByAuthor(String author) {

        Book temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Book not found.");
    }

    // Update availability
    public void updateAvailability(int id, boolean status) {

        Book temp = head;

        while (temp != null) {
            if (temp.bookId == id) {
                temp.available = status; // directly update node data
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book not found.");
    }

    // Display forward
    public void displayForward() {

        if (head == null) {
            System.out.println("No books available.");
            return;
        }

        Book temp = head;

        while (temp != null) {
            printBook(temp);
            temp = temp.next; // move forward
        }
    }

    // Display reverse
    public void displayReverse() {

        if (tail == null) {
            System.out.println("No books available.");
            return;
        }

        Book temp = tail;

        while (temp != null) {
            printBook(temp);
            temp = temp.prev; // move backward
        }
    }

    // Count total books
    public void countBooks() {

        int count = 0;
        Book temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total books in library: " + count);
    }

    // Helper method to print book details
    private void printBook(Book b) {
        System.out.println("ID: " + b.bookId +
                ", Title: " + b.title +
                ", Author: " + b.author +
                ", Genre: " + b.genre +
                ", Available: " + (b.available ? "Yes" : "No"));
    }
}

// Main driver class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryDoublyLinkedList list = new LibraryDoublyLinkedList(); // create list

        while (true) {

            System.out.println("\n---- Library Menu ----");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Book ID");
            System.out.println("5. Search by Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Count Books");
            System.out.println("11. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            switch (choice) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();

                    System.out.print("Available? (true/false): ");
                    boolean available = sc.nextBoolean();
                    sc.nextLine();

                    if (choice == 1)
                        list.addAtBeginning(title, author, genre, id, available);
                    else if (choice == 2)
                        list.addAtEnd(title, author, genre, id, available);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        list.addAtPosition(pos, title, author, genre, id, available);
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    list.removeById(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Title: ");
                    list.searchByTitle(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Author: ");
                    list.searchByAuthor(sc.nextLine());
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt();

                    System.out.print("Available? (true/false): ");
                    boolean status = sc.nextBoolean();

                    list.updateAvailability(bid, status);
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                case 10:
                    list.countBooks();
                    break;

                case 11:
                    System.out.println("Exiting program...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

