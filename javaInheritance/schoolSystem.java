package inheritance;

/*
 This program demonstrates hierarchical inheritance in a school system.
 It models a common Person class with different roles in a school.
 Each subclass represents a specific role with unique attributes.
 The example focuses on shared and specialized behavior.
*/

class BasePerson {
    String name;
    int age;

    BasePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayRole() { // displays generic person role
        System.out.println("Person in School");
    }
}

// Teacher subclass with subject specialization
class TeacherRole extends BasePerson {
    String subject;

    TeacherRole(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    void displayRole() { // displays teacher role
        System.out.println("Teacher | Subject: " + subject);
    }
}

// Student subclass with academic grade
class StudentRole extends BasePerson {
    String grade;

    StudentRole(String name, int age, String grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    void displayRole() { // displays student role
        System.out.println("Student | Grade: " + grade);
    }
}

// Staff subclass with department responsibility
class StaffRole extends BasePerson {
    String department;

    StaffRole(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    @Override
    void displayRole() { // displays staff role
        System.out.println("Staff | Department: " + department);
    }
}

// Main class to test school role hierarchy
public class SchoolHierarchy {

    public static void main(String[] args) { // program execution starts here
        BasePerson p1 = new TeacherRole("Mr. Sharma", 40, "Mathematics");
        BasePerson p2 = new StudentRole("Aarav", 16, "10th Grade");
        BasePerson p3 = new StaffRole("Ramesh", 45, "Administration");

        p1.displayRole();
        p2.displayRole();
        p3.displayRole();
    }
}

