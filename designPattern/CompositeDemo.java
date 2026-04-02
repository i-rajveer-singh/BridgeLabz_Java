package designpattern;

import java.util.ArrayList;
import java.util.List;

// 1. Component Interface
interface Employee1 {
    void showDetails();
}

// 2. Leaf Class
class Developer implements Employee1 {

    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Developer: " + name);
    }
}

// 3. Composite Class
class Manager implements Employee1 {

    private String name;
    private List<Employee> team = new ArrayList<>();

    public Manager(String name) {
        this.name = name;
    }

    public void addEmployee(Employee1 emp) {
        team.add(emp);
    }

    public void removeEmployee(Employee1 emp) {
        team.remove(emp);
    }

    public void showDetails() {
        System.out.println("Manager: " + name);
        for (Employee1 emp : team) {
            emp.showDetails();
        }
    }
}

// 4. Main Class
public class CompositeDemo {

    public static void main(String[] args) {

        Developer dev1 = new Developer("Prajwal");
        Developer dev2 = new Developer("Rahul");

        Manager manager = new Manager("Team Lead");
        manager.addEmployee(dev1);
        manager.addEmployee(dev2);

        manager.showDetails();
    }
}