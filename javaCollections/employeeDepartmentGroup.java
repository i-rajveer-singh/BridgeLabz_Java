package collections;
/*
 * EmployeeDepartmentGrouper groups employees by department
 * using a Map where each department maps to a list of employees.
 */

import java.util.*;

// Represents an employee
class Employee {
    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Returns department
    public String getDepartment() { return department; }

    // Formats employee name
    @Override
    public String toString() { return name; }
}

public class EmployeeDepartmentGrouper {

    // Groups employees by department
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {

        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee emp : employees) {
            grouped.computeIfAbsent(emp.getDepartment(), k -> new ArrayList<>())
                    .add(emp); // Add employee to department list
        }

        return grouped;
    }

    // Entry point
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice","HR"),
                new Employee("Bob","IT"),
                new Employee("Carol","HR")
        );

        System.out.println(groupByDepartment(employees));
    }
}
