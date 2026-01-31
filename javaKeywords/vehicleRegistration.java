/*
 * Vehicle class stores vehicle information
 * It is used for vehicle registration
 * Helps in managing vehicle records
 */

class Vehicle {

    static double registrationFee = 5000.0;

    final String registrationNumber;

    String ownerName;
    String vehicleType;

    // Constructor
    Vehicle(String ownerName, String vehicleType, String registrationNumber){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Display vehicle details
    void displayDetails(){
        System.out.println("\n----- Vehicle Registration Details -----");
        System.out.println("Owner Name         : " + ownerName);
        System.out.println("Vehicle Type       : " + vehicleType);
        System.out.println("Registration No.   : " + registrationNumber);
        System.out.println("Registration Fee   : " + registrationFee);
    }

    // Update registration fee
    static void updateRegistrationFee(double newFee){
        registrationFee = newFee;
    }

    // Main method
    public static void main(String[] args){

        Vehicle v1 = new Vehicle("Aaditya", "Car", "TN10AB1234");

        // instanceof check
        if(v1 instanceof Vehicle){
            v1.displayDetails();
        }

        Vehicle.updateRegistrationFee(6500.0);

        Vehicle v2 = new Vehicle("Riya", "Bike", "TN09XY5678");

        if(v2 instanceof Vehicle){
            v2.displayDetails();
        }
    }
}
