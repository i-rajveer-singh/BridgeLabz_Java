package fourpillars;

/*
 * UniqueEmployeeSystem demonstrates abstraction, encapsulation, interfaces,
 * and polymorphism in a single Java file. It models different employee types,
 * calculates salaries based on role, and processes them using a common reference.
 */

import java.util.*;

// Interface for department-related behavior
interface Department {
    void assignDepartment(String dept);
    String getDepartmentDetails();
}

// Abstract class enforcing salary calculation
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Abstract method forces subclasses to provide their own salary logic
    public abstract double calculateSalary();

    // Concrete method reused by all subclasses
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("----------------------");
    }

    // Getters and setters maintain encapsulation
    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    protected void setDepartmentInternal(String dept) {
        this.department = dept;
    }

    protected String getDepartmentInternal() {
        return department;
    }
}

// Full-time employee with fixed salary + bonus
class FullTimeEmployee extends Employee implements Department {
    private double bonus;

    public FullTimeEmployee(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void assignDepartment(String dept) {
        setDepartmentInternal(dept);
    }

    @Override
    public String getDepartmentDetails() {
        return "Full-Time Employee Department: " + getDepartmentInternal();
    }
}

// Part-time employee paid by hours worked
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int id, String name, double hourlyRate, int hoursWorked) {
        super(id, name, 0); // baseSalary not used for part-time
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public void assignDepartment(String dept) {
        setDepartmentInternal(dept);
    }

    @Override
    public String getDepartmentDetails() {
        return "Part-Time Employee Department: " + getDepartmentInternal();
    }
}

// Unique main class name to avoid conflicts
public class EmployeeSystem {
    public static void main(String[] args) {

        // Polymorphism: storing different employee types in Employee reference
        List<Employee> employees = new ArrayList<>();

        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Aaditya", 50000, 8000);
        emp1.assignDepartment("Engineering");

        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Siya", 500, 80);
        emp2.assignDepartment("Support");

        employees.add(emp1);
        employees.add(emp2);

        // Runtime polymorphism: correct calculateSalary() called automatically
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}

