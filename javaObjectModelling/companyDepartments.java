package objectmodelling;

import java.util.ArrayList;

/*
 * This program demonstrates Composition in Object Modeling.
 * Company owns Department objects and Departments own Employee objects.
 * If Company is deleted, all Departments and Employees are automatically removed.
 * This represents a strong "has-a" relationship (composition).
 */

class Employee {
    private String name;

    // Initializes employee
    public Employee(String name) {
        this.name = name;
    }

    // Displays employee name
    public void showEmployee() {
        System.out.println("Employee: " + name);
    }
}

class Department {
    private String deptName;
    private ArrayList<Employee> employees;

    // Initializes department
    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }

    // Adds employee to department
    public void addEmployee(String empName) {
        employees.add(new Employee(empName)); // Employee created inside Department
    }

    // Displays department details
    public void showDepartment() {
        System.out.println("\nDepartment: " + deptName);
        for (Employee e : employees) {
            e.showEmployee();
        }
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments;

    // Initializes company
    public Company(String companyName) {
        this.companyName = companyName;
        this.departments = new ArrayList<>();
    }

    // Adds department to company
    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    // Displays company structure
    public void showCompany() {
        System.out.println("\nCompany: " + companyName);
        for (Department d : departments) {
            d.showDepartment();
        }
    }

    // Deletes company and all associated objects
    public void deleteCompany() {
        departments.clear(); // Composition cleanup
        System.out.println("\nCompany deleted with all departments and employees.");
    }
}

public class CompanyComposition {
    public static void main(String[] args) {

        Company company = new Company("TechNova Pvt Ltd");

        Department d1 = new Department("IT");
        Department d2 = new Department("HR");

        d1.addEmployee("Aaditya");
        d1.addEmployee("Rahul");

        d2.addEmployee("Neha");
        d2.addEmployee("Priya");

        company.addDepartment(d1);
        company.addDepartment(d2);

        company.showCompany();

        // Composition effect
        company.deleteCompany();
    }
}
