package inheritance;

/*
 This program demonstrates an Employee Management System.
 It shows how inheritance is used to create different employee types.
 Method overriding is applied to customize behavior in subclasses.
 The example highlights basic object-oriented design principles.
*/

class BaseEmployee {
    String name;
    int id;
    double salary;

    BaseEmployee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() { // displays common employee details
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

// Manager subclass with additional responsibility
class ManagerEmployee extends BaseEmployee {
    int teamSize;

    ManagerEmployee(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    void displayDetails() { // displays manager-specific details
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Developer subclass with technical specialization
class DeveloperEmployee extends BaseEmployee {
    String programmingLanguage;

    DeveloperEmployee(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void displayDetails() { // displays developer-specific details
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Intern subclass with limited duration role
class InternEmployee extends BaseEmployee {
    int internshipDuration;

    InternEmployee(String name, int id, double salary, int internshipDuration) {
        super(name, id, salary);
        this.internshipDuration = internshipDuration;
    }

    @Override
    void displayDetails() { // displays intern-specific details
        super.displayDetails();
        System.out.println("Internship Duration: " + internshipDuration + " months");
    }
}

// Main class to test employee hierarchy
public class EmployeeManagement {

    public static void main(String[] args) { // program execution starts here
        BaseEmployee e1 = new ManagerEmployee("Aadi", 101, 80000, 5);
        BaseEmployee e2 = new DeveloperEmployee("Sanu", 102, 60000, "Java");
        BaseEmployee e3 = new InternEmployee("Siya", 103, 20000, 6);

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}

