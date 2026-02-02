package inheritance;

/*
 This program demonstrates hybrid inheritance in a vehicle management system.
 It combines class inheritance with interface-based behavior.
 Vehicle acts as the superclass while Refuelable adds extra capability.
 The example shows how Java supports multiple behaviors using interfaces.
*/

class BaseVehicle {
    int maxSpeed;
    String model;

    BaseVehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

// Interface defining refueling behavior
interface Refuelable {
    void refuel(); // refuels the vehicle
}

// ElectricVehicle subclass with charging feature
class ElectricVehicleType extends BaseVehicle {

    ElectricVehicleType(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    void charge() { // charges the electric vehicle
        System.out.println("Electric vehicle is charging");
    }
}

// PetrolVehicle subclass implementing refueling behavior
class PetrolVehicleType extends BaseVehicle implements Refuelable {

    PetrolVehicleType(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() { // refuels the petrol vehicle
        System.out.println("Petrol vehicle is being refueled");
    }
}

// Main class to test hybrid inheritance
public class VehicleHybrid {

    public static void main(String[] args) { // program execution starts here
        BaseVehicle ev = new ElectricVehicleType(160, "Tesla Model 3");
        PetrolVehicleType pv = new PetrolVehicleType(180, "Honda City");

        ((ElectricVehicleType) ev).charge();
        pv.refuel();
    }
}

