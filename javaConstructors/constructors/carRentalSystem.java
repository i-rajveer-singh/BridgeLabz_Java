package Level1;

import java.util.Scanner;

/*
 * This class simulates a simple car rental system.
 * It uses a parameterized constructor and Scanner input
 * to calculate and display total rental cost.
 */

class CarRental {

    private String customerName;
    private String carModel;
    private int rentalDays;
    private double pricePerDay = 1000;

    // Initializes rental details using constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Calculates total rental cost
    double calculateCost() {
        return rentalDays * pricePerDay;
    }

    // Displays customer, car, and total cost details
    void display() {
        System.out.println(customerName + " | " + carModel + " | Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateCost());
    }

    // Main method to take input and display rental bill
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Customer Name: ");
        String c = sc.nextLine();
        System.out.print("Car Model: ");
        String m = sc.nextLine();
        System.out.print("Rental Days: ");
        int d = sc.nextInt();

        CarRental r = new CarRental(c, m, d);
        r.display();
    }
}
