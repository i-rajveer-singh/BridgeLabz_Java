package objectmodelling;

import java.util.ArrayList;

/*
 * This program demonstrates Composition and Aggregation in Object Modeling.
 * University and Department have a composition relationship (strong ownership).
 * Faculty and University have an aggregation relationship (weak association).
 * Deleting University deletes Departments but Faculty can exist independently.
 */

class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void showFaculty() {
        System.out.println("Faculty: " + name);
    }

    public String getName() {
        return name;
    }
}

class UniversityDepartment {   // 🔁 renamed class
    private String deptName;

    public UniversityDepartment(String deptName) {
        this.deptName = deptName;
    }

    public void showDepartment() {
        System.out.println("Department: " + deptName);
    }
}

class University {
    private String universityName;
    private ArrayList<UniversityDepartment> departments;   // Composition
    private ArrayList<Faculty> faculties;                   // Aggregation

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Adds department to university (Composition)
    public void addDepartment(UniversityDepartment dept) {
        departments.add(dept);
    }

    // Adds faculty to university (Aggregation)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showUniversity() {
        System.out.println("\nUniversity: " + universityName);

        System.out.println("Departments:");
        for (UniversityDepartment d : departments) {
            d.showDepartment();
        }

        System.out.println("\nFaculties:");
        for (Faculty f : faculties) {
            f.showFaculty();
        }
    }

    // Deletes university and its departments (Composition effect)
    public void deleteUniversity() {
        departments.clear();
        System.out.println("\nUniversity deleted with all departments.");
    }
}

public class UniversityCompositionAggregation {
    public static void main(String[] args) {

        University uni = new University("SRM University");

        UniversityDepartment d1 = new UniversityDepartment("Computer Science");
        UniversityDepartment d2 = new UniversityDepartment("Mechanical");

        Faculty f1 = new Faculty("Dr. Sharma");
        Faculty f2 = new Faculty("Dr. Mehta");
        Faculty f3 = new Faculty("Dr. Rao");

        uni.addDepartment(d1);
        uni.addDepartment(d2);

        uni.addFaculty(f1);
        uni.addFaculty(f2);
        uni.addFaculty(f3);

        uni.showUniversity();

        // Composition effect
        uni.deleteUniversity();

        // Aggregation proof
        System.out.println("\nFaculty still exists independently:");
        f1.showFaculty();
        f2.showFaculty();
        f3.showFaculty();
    }
}
