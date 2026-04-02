package designpattern;
// 1. Product Interfaces
interface Car {
    void drive();
}

interface Bike {
    void ride();
}

// 2. Concrete Car Classes
class Sedan implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Sedan Car");
    }
}

class SUV implements Car {
    @Override
    public void drive() {
        System.out.println("Driving SUV Car");
    }
}

// 3. Concrete Bike Classes
class SportsBike implements Bike {
    @Override
    public void ride() {
        System.out.println("Riding Sports Bike");
    }
}

class NormalBike implements Bike {
    @Override
    public void ride() {
        System.out.println("Riding Normal Bike");
    }
}

// 4. Abstract Factory
abstract class VehicleFactory {
    abstract Car createCar(String type);
    abstract Bike createBike(String type);
}

// 5. Car Factory
class CarFactory extends VehicleFactory {

    @Override
    Car createCar(String type) {
        if (type.equalsIgnoreCase("sedan")) {
            return new Sedan();
        } else if (type.equalsIgnoreCase("suv")) {
            return new SUV();
        }
        return null;
    }

    @Override
    Bike createBike(String type) {
        return null; // Not responsible for bikes
    }
}

// 6. Bike Factory
class BikeFactory extends VehicleFactory {

    @Override
    Car createCar(String type) {
        return null; // Not responsible for cars
    }

    @Override
    Bike createBike(String type) {
        if (type.equalsIgnoreCase("sports")) {
            return new SportsBike();
        } else if (type.equalsIgnoreCase("normal")) {
            return new NormalBike();
        }
        return null;
    }
}

// 7. Main Class
public class AbstractFactoryDemo {

    public static void main(String[] args) {

        VehicleFactory carFactory = new CarFactory();
        Car car = carFactory.createCar("sedan");
        car.drive();

        VehicleFactory bikeFactory = new BikeFactory();
        Bike bike = bikeFactory.createBike("sports");
        bike.ride();
    }
}
