package linkedlist;

/*
 * TicketCircularLinkedList manages movie ticket reservations
 * using a circular linked list. Supports adding, removing,
 * searching tickets, displaying reservations, and counting bookings.
 */

import java.util.Scanner;

// Node representing each ticket
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next; // pointer to next ticket

    Ticket(int id, String customer, String movie, String seat, String time) {
        this.ticketId = id;
        this.customerName = customer;
        this.movieName = movie;
        this.seatNumber = seat;
        this.bookingTime = time;
        this.next = null;
    }
}

// Circular Linked List class
class TicketCircularLinkedList {

    private Ticket head; // first ticket
    private Ticket tail; // last ticket

    // Add ticket at end
    public void addTicket(int id, String customer, String movie, String seat, String time) {

        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            tail.next = head; // maintain circular link
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; // last must point to head
        }

        System.out.println("Ticket booked successfully.");
    }

    // Remove ticket by ID
    public void removeTicket(int id) {

        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket current = head;
        Ticket prev = tail;

        // special case: deleting head
        if (head.ticketId == id) {

            if (head == tail) { // only one ticket
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head; // restore circular structure
            }

            System.out.println("Ticket removed.");
            return;
        }

        do {
            prev = current;
            current = current.next;
        } while (current != head && current.ticketId != id);

        if (current.ticketId != id) {
            System.out.println("Ticket not found.");
            return;
        }

        prev.next = current.next;

        if (current == tail) {
            tail = prev; // update tail if last node removed
        }

        System.out.println("Ticket removed.");
    }

    // Display all tickets
    public void displayTickets() {

        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;

        do {
            printTicket(temp);
            temp = temp.next;
        } while (temp != head); // ensures full circular traversal
    }

    // Search by customer name
    public void searchByCustomer(String customer) {

        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(customer)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for this customer.");
    }

    // Search by movie name
    public void searchByMovie(String movie) {

        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        Ticket temp = head;
        boolean found = false;

        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                printTicket(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for this movie.");
    }

    // Count total tickets
    public void countTickets() {

        if (head == null) {
            System.out.println("Total booked tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;

        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total booked tickets: " + count);
    }

    // Helper method to print ticket
    private void printTicket(Ticket t) {
        System.out.println("Ticket ID: " + t.ticketId +
                ", Customer: " + t.customerName +
                ", Movie: " + t.movieName +
                ", Seat: " + t.seatNumber +
                ", Time: " + t.bookingTime);
    }
}

// Main driver class
public class TicketReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketCircularLinkedList list = new TicketCircularLinkedList(); // create reservation list

        while (true) {

            System.out.println("\n---- Ticket Reservation Menu ----");
            System.out.println("1. Book Ticket");
            System.out.println("2. Remove Ticket");
            System.out.println("3. Display Tickets");
            System.out.println("4. Search by Customer");
            System.out.println("5. Search by Movie");
            System.out.println("6. Count Tickets");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            switch (choice) {

                case 1:

                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();

                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();

                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();

                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();

                    list.addTicket(id, customer, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID: ");
                    list.removeTicket(sc.nextInt());
                    break;

                case 3:
                    list.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name: ");
                    list.searchByCustomer(sc.nextLine());
                    break;

                case 5:
                    System.out.print("Enter Movie Name: ");
                    list.searchByMovie(sc.nextLine());
                    break;

                case 6:
                    list.countTickets();
                    break;

                case 7:
                    System.out.println("Exiting system...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
