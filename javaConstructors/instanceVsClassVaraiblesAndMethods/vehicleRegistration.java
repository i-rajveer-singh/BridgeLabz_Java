package instancevsclass;

import java.util.Scanner;

/*
 * This class demonstrates the use of instance and class variables.
 * It uses instance variables for vehicle details and
 * a static variable for registration fee management.
 */

class Vehicle {

    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable
    static double registrationFee = 5000;

    // Initializes vehicle details using constructor
    Vehicle(String owner, String type) {
        this.ownerName = owner;
        this.vehicleType = type;
    }

    // Displays vehicle details and registration fee
    void displayVehicleDetails() {
        System.out.println("Owner: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    // Updates class variable registration fee
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    // Main method to take input and demonstrate instance vs class variables
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Owner name: ");
        String o = sc.nextLine();
        System.out.print("Vehicle type: ");
        String v = sc.nextLine();
        System.out.print("New registration fee: ");
        double fee = sc.nextDouble();

        Vehicle.updateRegistrationFee(fee);

        Vehicle ve = new Vehicle(o, v);
        ve.displayVehicleDetails();
    }
}
