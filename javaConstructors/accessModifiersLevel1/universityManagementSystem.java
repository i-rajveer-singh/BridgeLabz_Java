package accessmodifiers;

import java.util.Scanner;

/*
 * This program demonstrates the use of access modifiers in Java.
 * It shows public, protected, and private variables along with
 * inheritance and getter/setter methods for data access.
 */

class Student {

    public int rollNumber;      // public variable
    protected String name;      // protected variable
    private double CGPA;        // private variable

    // Sets value for private CGPA
    public void setCGPA(double c) {
        CGPA = c;
    }

    // Returns value of private CGPA
    public double getCGPA() {
        return CGPA;
    }

    // Main method to take input and demonstrate access modifiers
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PostgraduateStudent p = new PostgraduateStudent();

        System.out.print("Roll Number: ");
        p.rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        p.name = sc.nextLine();

        System.out.print("CGPA: ");
        double c = sc.nextDouble();
        p.setCGPA(c);

        p.display();
        System.out.println("CGPA: " + p.getCGPA());
    }
}

/*
 * This class extends Student class.
 * It accesses public and protected members using inheritance.
 */

class PostgraduateStudent extends Student {

    // Displays inherited student details
    void display() {
        System.out.println("Roll No: " + rollNumber);
        System.out.println("Name: " + name);
    }
}
