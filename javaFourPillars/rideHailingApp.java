package fourpillars;
/*
 * UniqueRideNavigator models a ride-hailing application using abstraction,
 * encapsulation, interfaces, and polymorphism. It calculates fares dynamically
 * for different ride vehicles while securely managing driver and vehicle data.
 */

import java.util.*;

// Interface defining GPS behavior
interface RideGPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

// Abstract base class for all ride vehicles
abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation; // Controlled internally for security

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Not Updated";
    }

    // Forces subclasses to implement fare logic
    public abstract double calculateFare(double distance);

    // Displays non-sensitive vehicle details
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
        System.out.println("Location: " + currentLocation);
        System.out.println("----------------------");
    }

    // Getters ensure controlled access
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    protected void setCurrentLocationInternal(String location) {
        this.currentLocation = location;
    }

    protected String getCurrentLocationInternal() {
        return currentLocation;
    }
}

// Car with base fare addition
class RideCar extends RideVehicle implements RideGPS {

    public RideCar(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 50; // Base fare
    }

    @Override
    public String getCurrentLocation() {
        return getCurrentLocationInternal();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocationInternal(location);
    }
}

// Bike with cheaper fare
class RideBike extends RideVehicle implements RideGPS {

    public RideBike(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return getCurrentLocationInternal();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocationInternal(location);
    }
}

// Auto with booking fee
class RideAuto extends RideVehicle implements RideGPS {

    public RideAuto(String id, String driver, double rate) {
        super(id, driver, rate);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 20; // Booking fee
    }

    @Override
    public String getCurrentLocation() {
        return getCurrentLocationInternal();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocationInternal(location);
    }
}

// Unique main class name to avoid conflicts
public class RideNavigator {

    // Calculates fares dynamically using polymorphism
    public static void calculateRideFares(List<RideVehicle> vehicles, double distance) {
        for (RideVehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
            System.out.println("======================");
        }
    }

    public static void main(String[] args) {

        // Polymorphism: storing different ride types in RideVehicle reference
        List<RideVehicle> fleet = new ArrayList<>();

        RideCar car = new RideCar("CAR101", "Aaditya", 15);
        RideBike bike = new RideBike("BIKE202", "Riya", 8);
        RideAuto auto = new RideAuto("AUTO303", "Rahul", 10);

        // Updating GPS locations via interface
        ((RideGPS) car).updateLocation("Central Mall");
        ((RideGPS) bike).updateLocation("Metro Station");
        ((RideGPS) auto).updateLocation("Airport");

        fleet.add(car);
        fleet.add(bike);
        fleet.add(auto);

        // Runtime polymorphism ensures correct fare calculation
        calculateRideFares(fleet, 12.5);
    }
}
