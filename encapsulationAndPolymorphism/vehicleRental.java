package fourpillars;

/*
 * UniqueVehicleRentalHub demonstrates abstraction, interfaces,
 * encapsulation, and polymorphism in a vehicle rental context.
 * It calculates rental and insurance costs for multiple vehicle types.
 */

import java.util.*;

// Interface for vehicles that provide insurance
interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

// Abstract base class defining common vehicle structure
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber; // Sensitive detail

    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // Forces subclasses to implement rental calculation
    public abstract double calculateRentalCost(int days);

    // Displays rental + insurance using polymorphism
    public void displayCost(int days) {
        double rentalCost = calculateRentalCost(days);
        double insurance = 0;

        // Only vehicles implementing Insurable calculate insurance
        if (this instanceof Insurable) {
            insurance = ((Insurable) this).calculateInsurance(days);
        }

        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Cost for " + days + " days: " + rentalCost);
        System.out.println("Insurance Cost: " + insurance);
        System.out.println("Total Cost: " + (rentalCost + insurance));
        System.out.println("----------------------");
    }

    // Getters ensure controlled access
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) { // Prevent invalid rate updates
            this.rentalRate = rentalRate;
        }
    }

    // No getter for policy number to keep it protected
    protected String getInsurancePolicyNumberInternal() {
        return insurancePolicyNumber;
    }
}

// Car with standard insurance and slight discount for longer rentals
class Car extends Vehicle implements Insurable {

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        double cost = getRentalRate() * days;
        if (days > 7) { // Discount for weekly rentals
            cost *= 0.90;
        }
        return cost;
    }

    @Override
    public double calculateInsurance(int days) {
        return 50 * days; // Fixed daily insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy Active";
    }
}

// Bike with cheaper rental and insurance
class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 20 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy Active";
    }
}

// Truck with higher insurance due to risk
class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 200 * days; // Includes maintenance fee
    }

    @Override
    public double calculateInsurance(int days) {
        return 100 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Commercial Insurance Active";
    }
}

// Unique main class name to avoid conflicts
public class VehicleRentalHub {
    public static void main(String[] args) {

        // Polymorphism: storing different vehicle types in Vehicle reference
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("TN10AB1234", 2000, "CAR-7890"));
        vehicles.add(new Bike("TN09XY5678", 800, "BIKE-4567"));
        vehicles.add(new Truck("TN22TR9999", 5000, "TRUCK-1122"));

        // Runtime polymorphism ensures correct cost calculation
        for (Vehicle v : vehicles) {
            v.displayCost(5);
        }
    }
}
