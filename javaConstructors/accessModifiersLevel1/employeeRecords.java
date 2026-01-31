package accessmodifiers;

import java.util.Scanner;

/*
 * This program demonstrates access modifiers in Java.
 * It shows the use of public, protected, and private variables
 * along with inheritance and getter/setter methods.
 */

class Employee {

    public int employeeID;        // public variable
    protected String department;  // protected variable
    private double salary;        // private variable

    // Sets value for private salary
    public void setSalary(double s) {
        salary = s;
    }

    // Returns value of private salary
    public double getSalary() {
        return salary;
    }

    // Main method to take input and demonstrate access control
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Manager m = new Manager();

        System.out.print("Employee ID: ");
        m.employeeID = sc.nextInt();
        sc.nextLine();

        System.out.print("Department: ");
        m.department = sc.nextLine();

        System.out.print("Salary: ");
        double s = sc.nextDouble();
        m.setSalary(s);

        m.display();
        System.out.println("Salary: " + m.getSalary());
    }
}

/*
 * This class extends Employee.
 * It accesses public and protected members using inheritance.
 */

class Manager extends Employee {

    // Displays inherited employee details
    void display() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}
