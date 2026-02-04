package fourpillars;

/*
 * UniqueHospitalCare demonstrates a hospital patient management system
 * using abstraction, encapsulation, interfaces, and polymorphism.
 * It securely stores medical records and dynamically calculates bills
 * for different patient types.
 */

import java.util.*;

// Interface defining medical record behavior
interface MedicalRecord {
    void addRecord(String diagnosis);
    void viewRecords();
}

// Abstract base class for patients
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private List<String> medicalHistory; // Sensitive data

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.medicalHistory = new ArrayList<>();
    }

    // Forces subclasses to implement billing logic
    public abstract double calculateBill();

    // Displays non-sensitive patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Bill: " + calculateBill());
        System.out.println("----------------------");
    }

    // Protected methods restrict direct access to medical history
    protected void addMedicalHistory(String diagnosis) {
        medicalHistory.add(diagnosis);
    }

    protected List<String> getMedicalHistoryInternal() {
        return medicalHistory;
    }
}

// In-patient with room charges and daily care fees
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int id, String name, int age, int daysAdmitted, double dailyRate) {
        super(id, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate + 2000; // Includes treatment fee
    }

    @Override
    public void addRecord(String diagnosis) {
        addMedicalHistory(diagnosis);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + getMedicalHistoryInternal());
    }
}

// Out-patient with consultation-based billing
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;

    public OutPatient(int id, String name, int age, double consultationFee) {
        super(id, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee + 500; // Includes basic tests
    }

    @Override
    public void addRecord(String diagnosis) {
        addMedicalHistory(diagnosis);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + getMedicalHistoryInternal());
    }
}

// Unique main class name to avoid conflicts
public class HospitalCare {

    // Processes patients using polymorphism
    public static void processPatients(List<Patient> patients) {
        for (Patient p : patients) {
            p.getPatientDetails();
        }
    }

    public static void main(String[] args) {

        // Polymorphism: storing different patient types in Patient reference
        List<Patient> patients = new ArrayList<>();

        InPatient p1 = new InPatient(1, "Aaditya", 21, 5, 3000);
        OutPatient p2 = new OutPatient(2, "Riya", 24, 800);

        // Adding medical records securely
        ((MedicalRecord) p1).addRecord("Pneumonia");
        ((MedicalRecord) p2).addRecord("Seasonal Flu");

        patients.add(p1);
        patients.add(p2);

        // Runtime polymorphism ensures correct billing
        processPatients(patients);

        // Viewing records via interface
        ((MedicalRecord) p1).viewRecords();
        ((MedicalRecord) p2).viewRecords();
    }
}

