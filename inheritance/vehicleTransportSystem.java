/*
 This program demonstrates a Vehicle and Transport System.
 It shows how inheritance organizes common and unique features.
 Subclasses override methods to provide specific behavior.
 Polymorphism is demonstrated using a Vehicle array.
*/

class BaseVehicle {
    int maxSpeed;
    String fuelType;
    String vehicleName;

    BaseVehicle(String vehicleName, int maxSpeed, String fuelType) {
        this.vehicleName = vehicleName;
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    void displayInfo() { // displays common vehicle information
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Max Speed: " + maxSpeed + " km/h, Fuel Type: " + fuelType);
    }
}

// Car subclass with seating capacity
class CarVehicle extends BaseVehicle {
    int seatCapacity;

    CarVehicle(int maxSpeed, String fuelType, int seatCapacity) {
        super("Car", maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    void displayInfo() { // displays car-specific information
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

// Truck subclass with load capacity
class TruckVehicle extends BaseVehicle {
    double loadCapacity;

    TruckVehicle(int maxSpeed, String fuelType, double loadCapacity) {
        super("Truck", maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    void displayInfo() { // displays truck-specific information
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Motorcycle subclass with engine capacity
class MotorcycleVehicle extends BaseVehicle {
    int engineCC;

    MotorcycleVehicle(int maxSpeed, String fuelType, int engineCC) {
        super("Motorcycle", maxSpeed, fuelType);
        this.engineCC = engineCC;
    }

    @Override
    void displayInfo() { // displays motorcycle-specific information
        super.displayInfo();
        System.out.println("Engine Capacity: " + engineCC + " cc");
    }
}

// Main class to demonstrate polymorphism
public class VehicleTransportDemo {

    public static void main(String[] args) { // program execution starts here
        BaseVehicle[] vehicles = new BaseVehicle[3];

        vehicles[0] = new CarVehicle(180, "Petrol", 5);
        vehicles[1] = new TruckVehicle(120, "Diesel", 12.5);
        vehicles[2] = new MotorcycleVehicle(160, "Petrol", 350);

        for (BaseVehicle v : vehicles) {
            v.displayInfo();
            System.out.println();
        }
    }
}
