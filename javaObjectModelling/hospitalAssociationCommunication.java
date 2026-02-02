package objectmodelling;

import java.util.ArrayList;

/*
 * This program demonstrates Association and Object Communication.
 * Doctor and Patient have a many-to-many association.
 * Doctors and Patients interact through consultations.
 * Communication is shown using the consult() method.
 */

class Patient {
    private String name;
    private ArrayList<Doctor> doctors;

    // Initializes patient
    public Patient(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
    }

    // Adds doctor to patient's list
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Returns patient name
    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private ArrayList<Patient> patients;

    // Initializes doctor
    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    // Consultation between doctor and patient (communication)
    public void consult(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this);   // Association link

        System.out.println("Consultation: Dr. " + name + " is consulting patient " + patient.getName());
    }

    // Returns doctor name
    public String getName() {
        return name;
    }
}

class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    // Initializes hospital
    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Adds doctor to hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Adds patient to hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Displays hospital details
    public void showHospital() {
        System.out.println("\nHospital: " + hospitalName);

        System.out.println("\nDoctors:");
        for (Doctor d : doctors) {
            System.out.println("Dr. " + d.getName());
        }

        System.out.println("\nPatients:");
        for (Patient p : patients) {
            System.out.println(p.getName());
        }
    }
}

public class HospitalAssociationCommunication {
    public static void main(String[] args) {

        Hospital hospital = new Hospital("City Care Hospital");

        Doctor d1 = new Doctor("Sharma");
        Doctor d2 = new Doctor("Mehta");

        Patient p1 = new Patient("Aaditya");
        Patient p2 = new Patient("Rahul");
        Patient p3 = new Patient("Neha");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);

        hospital.addPatient(p1);
        hospital.addPatient(p2);
        hospital.addPatient(p3);

        hospital.showHospital();

        // Consultations (Association + Communication)
        d1.consult(p1);
        d1.consult(p2);

        d2.consult(p2);
        d2.consult(p3);
    }
}

