/*
 * Patient class stores patient information
 * It is used in hospital management
 * Helps in managing patient records
 */

class Patient {

    static String hospitalName = "SRM Hospital";
    private static int totalPatients = 0;

    final int patientID;

    String name;
    int age;
    String ailment;

    // Constructor
    Patient(String name, int patientID, int age, String ailment){
        this.name = name;
        this.patientID = patientID;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Display patient details
    void displayDetails(){
        System.out.println("\n----- Patient Details -----");
        System.out.println("Hospital Name : " + hospitalName);
        System.out.println("Name          : " + name);
        System.out.println("Patient ID    : " + patientID);
        System.out.println("Age           : " + age);
        System.out.println("Ailment       : " + ailment);
    }

    // Display total patients
    static void getTotalPatients(){
        System.out.println("\nTotal Patients Admitted : " + totalPatients);
    }

    // Main method
    public static void main(String[] args){

        Patient p1 = new Patient("Aaditya", 401, 20, "Fever");

        // instanceof check
        if(p1 instanceof Patient){
            p1.displayDetails();
        }

        Patient p2 = new Patient("Siya", 402, 25, "Cold");

        if(p2 instanceof Patient){
            p2.displayDetails();
        }

        Patient.getTotalPatients();
    }
}
