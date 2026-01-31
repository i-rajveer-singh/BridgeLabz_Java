package Level1;

import java.util.Scanner;

/*
 * This class simulates a hotel booking system.
 * It uses default, parameterized, and copy constructors
 * with Scanner input to manage booking details.
 */

class HotelBooking {

    private String guestName;
    private String roomType;
    private int nights;

    // Initializes booking with default values
    HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Initializes booking using parameterized constructor
    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Initializes booking using copy constructor
    HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    // Displays booking details
    void display() {
        System.out.println(guestName + " | " + roomType + " | " + nights);
    }

    // Main method to take input and demonstrate constructors
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Guest Name: ");
        String g = sc.nextLine();
        System.out.print("Room Type: ");
        String r = sc.nextLine();
        System.out.print("Nights: ");
        int n = sc.nextInt();

        HotelBooking b1 = new HotelBooking(g, r, n);
        HotelBooking b2 = new HotelBooking(b1);

        b1.display();
        b2.display();
    }
}
