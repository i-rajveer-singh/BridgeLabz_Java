package objectmodelling;

import java.util.ArrayList;

/*
 * This program demonstrates Association and Aggregation in a University System.
 * Students enroll in courses and professors teach courses.
 * University aggregates students and professors.
 * Communication is shown through enrollCourse() and assignProfessor().
 */

class UniCourse {
    private String courseName;
    private UniProfessor professor;
    private ArrayList<UniStudent> students;

    public UniCourse(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Assigns professor to course (communication)
    public void assignProfessor(UniProfessor professor) {
        this.professor = professor;
    }

    // Adds student to course
    public void addStudent(UniStudent student) {
        students.add(student);
    }

    // Displays course details
    public void showCourse() {
        System.out.println("\nCourse: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Students:");
        for (UniStudent s : students) {
            System.out.println(s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

class UniStudent {
    private String name;
    private ArrayList<UniCourse> courses;

    public UniStudent(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Student enrolls in course (communication)
    public void enrollCourse(UniCourse course) {
        courses.add(course);
        course.addStudent(this);
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    // Displays student's courses
    public void showCourses() {
        System.out.println("\nCourses of " + name + ":");
        for (UniCourse c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

class UniProfessor {
    private String name;
    private ArrayList<UniCourse> courses;

    public UniProfessor(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Professor assigned to course (communication)
    public void assignProfessor(UniCourse course) {
        courses.add(course);
        course.assignProfessor(this);
        System.out.println("Prof. " + name + " assigned to " + course.getCourseName());
    }

    // Displays courses taught by professor
    public void showCourses() {
        System.out.println("\nCourses taught by Prof. " + name + ":");
        for (UniCourse c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

class UniversitySystem {
    private String universityName;
    private ArrayList<UniStudent> students;
    private ArrayList<UniProfessor> professors;

    public UniversitySystem(String universityName) {
        this.universityName = universityName;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
    }

    // Aggregation: add student
    public void addStudent(UniStudent student) {
        students.add(student);
    }

    // Aggregation: add professor
    public void addProfessor(UniProfessor professor) {
        professors.add(professor);
    }

    // Displays university members
    public void showUniversity() {
        System.out.println("\nUniversity: " + universityName);

        System.out.println("\nStudents:");
        for (UniStudent s : students) {
            System.out.println(s.getName());
        }

        System.out.println("\nProfessors:");
        for (UniProfessor p : professors) {
            System.out.println(p.getName());
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {

        UniversitySystem uni = new UniversitySystem("SRM University");

        UniStudent s1 = new UniStudent("Aaditya");
        UniStudent s2 = new UniStudent("Rahul");

        UniProfessor p1 = new UniProfessor("Dr. Sharma");
        UniProfessor p2 = new UniProfessor("Dr. Mehta");

        UniCourse c1 = new UniCourse("Data Structures");
        UniCourse c2 = new UniCourse("Artificial Intelligence");

        uni.addStudent(s1);
        uni.addStudent(s2);

        uni.addProfessor(p1);
        uni.addProfessor(p2);

        // Professor-course communication
        p1.assignProfessor(c1);
        p2.assignProfessor(c2);

        // Student-course communication
        s1.enrollCourse(c1);
        s1.enrollCourse(c2);
        s2.enrollCourse(c1);

        uni.showUniversity();

        s1.showCourses();
        s2.showCourses();

        p1.showCourses();
        p2.showCourses();

        c1.showCourse();
        c2.showCourse();
    }
}
