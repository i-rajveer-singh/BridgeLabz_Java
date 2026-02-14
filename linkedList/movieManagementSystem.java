package linkedlist;



/*
 * MovieDoublyLinkedList manages movie records using a doubly linked list.
 * Supports insertion, deletion, searching, updating ratings,
 * and displaying records in both forward and reverse order.
 */

import java.util.Scanner;

// Node class representing each movie
class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next; // pointer to next node
    Movie prev; // pointer to previous node

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null; // ensures clean linkage
        this.prev = null;
    }
}

// Doubly Linked List class
class MovieDoublyLinkedList {

    private Movie head; // start of list
    private Movie tail; // end of list (important for reverse traversal)

    // Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {

        Movie newMovie = new Movie(title, director, year, rating);

        if (head == null) { // handles empty list
            head = tail = newMovie;
        } else {
            newMovie.next = head; // link new node to current head
            head.prev = newMovie; // back link
            head = newMovie; // shift head
        }

        System.out.println("Movie added at beginning.");
    }

    // Add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {

        Movie newMovie = new Movie(title, director, year, rating);

        if (tail == null) { // empty list case
            head = tail = newMovie;
        } else {
            tail.next = newMovie; // attach at end
            newMovie.prev = tail; // back reference
            tail = newMovie; // move tail forward
        }

        System.out.println("Movie added at end.");
    }

    // Add movie at specific position
    public void addAtPosition(int pos, String title, String director, int year, double rating) {

        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        Movie temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next; // traverse to node before position
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        if (temp.next == null) { // inserting at last position
            addAtEnd(title, director, year, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, year, rating);

        newMovie.next = temp.next; // preserve forward chain
        newMovie.prev = temp;

        temp.next.prev = newMovie; // fix backward link
        temp.next = newMovie;

        System.out.println("Movie added at position " + pos);
    }

    // Remove movie by title
    public void removeByTitle(String title) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Movie temp = head;

        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next; // search movie
        }

        if (temp == null) {
            System.out.println("Movie not found.");
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
            temp.prev.next = temp.next; // bypass node forward
            temp.next.prev = temp.prev; // bypass node backward
        }

        System.out.println("Movie removed.");
    }

    // Search by director
    public void searchByDirector(String director) {

        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found for this director.");
    }

    // Search by rating
    public void searchByRating(double rating) {

        Movie temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("No movies found with this rating.");
    }

    // Update rating using title
    public void updateRating(String title, double newRating) {

        Movie temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating; // directly update node data
                System.out.println("Rating updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found.");
    }

    // Display forward
    public void displayForward() {

        if (head == null) {
            System.out.println("No records available.");
            return;
        }

        Movie temp = head;

        while (temp != null) {
            printMovie(temp);
            temp = temp.next; // move ahead
        }
    }

    // Display reverse
    public void displayReverse() {

        if (tail == null) {
            System.out.println("No records available.");
            return;
        }

        Movie temp = tail;

        while (temp != null) {
            printMovie(temp);
            temp = temp.prev; // traverse backward
        }
    }

    // Helper method to print movie details
    private void printMovie(Movie m) {
        System.out.println("Title: " + m.title +
                ", Director: " + m.director +
                ", Year: " + m.year +
                ", Rating: " + m.rating);
    }
}

// Main driver class
public class MovieManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList(); // create list object

        while (true) {

            System.out.println("\n---- Movie Management Menu ----");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Update Rating");
            System.out.println("8. Display Forward");
            System.out.println("9. Display Reverse");
            System.out.println("10. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            switch (choice) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Director: ");
                    String director = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();

                    System.out.print("Enter Rating: ");
                    double rating = sc.nextDouble();
                    sc.nextLine();

                    if (choice == 1)
                        list.addAtBeginning(title, director, year, rating);
                    else if (choice == 2)
                        list.addAtEnd(title, director, year, rating);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        sc.nextLine();
                        list.addAtPosition(pos, title, director, year, rating);
                    }
                    break;

                case 4:
                    System.out.print("Enter Title to remove: ");
                    list.removeByTitle(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Director: ");
                    list.searchByDirector(sc.nextLine());
                    break;

                case 6:
                    System.out.print("Enter Rating: ");
                    list.searchByRating(sc.nextDouble());
                    break;

                case 7:
                    System.out.print("Enter Title: ");
                    String t = sc.nextLine();

                    System.out.print("Enter New Rating: ");
                    double r = sc.nextDouble();
                    sc.nextLine();

                    list.updateRating(t, r);
                    break;

                case 8:
                    list.displayForward();
                    break;

                case 9:
                    list.displayReverse();
                    break;

                case 10:
                    System.out.println("Exiting program...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

