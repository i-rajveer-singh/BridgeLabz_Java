package instancevsclass;

import java.util.Scanner;

/*
 * This class demonstrates the difference between
 * instance variables and class variables.
 * It uses instance and static methods to display data.
 */

class Course {

    // Instance variables
    String courseName;
    int duration;
    double fee;

    // Class variable
    static String instituteName = "Default Institute";

    // Initializes course details using constructor
    Course(String name, int duration, double fee) {
        this.courseName = name;
        this.duration = duration;
        this.fee = fee;
    }

    // Displays instance and class variable values
    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: " + fee);
        System.out.println("Institute: " + instituteName);
    }

    // Updates class variable value
    static void updateInstituteName(String name) {
        instituteName = name;
    }

    // Main method to take input and demonstrate instance vs class variables
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter course name: ");
        String cn = sc.nextLine();
        System.out.print("Enter duration (months): ");
        int d = sc.nextInt();
        System.out.print("Enter fee: ");
        double f = sc.nextDouble();
        sc.nextLine();
        System.out.print("Enter institute name: ");
        String inst = sc.nextLine();

        Course.updateInstituteName(inst);

        Course c = new Course(cn, d, f);
        c.displayCourseDetails();
    }
}
