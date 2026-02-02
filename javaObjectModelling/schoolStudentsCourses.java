package objectmodelling;

import java.util.ArrayList;

/*
 * This program demonstrates Association and Aggregation in Object Modeling.
 * School aggregates Student objects (students can exist independently).
 * Student and Course have an association (many-to-many relationship).
 * Students can enroll in multiple courses and courses can have multiple students.
 */

class Course {
    private String courseName;
    private ArrayList<Student> students;

    // Initializes course
    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    // Adds student to course
    public void addStudent(Student student) {
        students.add(student);
    }

    // Displays enrolled students
    public void showStudents() {
        System.out.println("\nStudents enrolled in " + courseName + ":");
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }

    // Returns course name
    public String getCourseName() {
        return courseName;
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses;

    // Initializes student
    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Enrolls student in a course
    public void enroll(Course course) {
        courses.add(course);
        course.addStudent(this);   // Association communication
    }

    // Displays enrolled courses
    public void viewCourses() {
        System.out.println("\nCourses of " + name + ":");
        for (Course c : courses) {
            System.out.println(c.getCourseName());
        }
    }

    // Returns student name
    public String getName() {
        return name;
    }
}

class School {
    private String schoolName;
    private ArrayList<Student> students;

    // Initializes school
    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new ArrayList<>();
    }

    // Adds student to school (Aggregation)
    public void addStudent(Student student) {
        students.add(student);
    }

    // Displays all students in school
    public void showStudents() {
        System.out.println("\nStudents in " + schoolName + ":");
        for (Student s : students) {
            System.out.println(s.getName());
        }
    }
}

public class SchoolAssociationAggregation {
    public static void main(String[] args) {

        School school = new School("SRM Public School");

        Student s1 = new Student("Aaditya");
        Student s2 = new Student("Rahul");
        Student s3 = new Student("Neha");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Computer Science");
        Course c3 = new Course("Physics");

        s1.enroll(c1);
        s1.enroll(c2);

        s2.enroll(c2);
        s2.enroll(c3);

        s3.enroll(c1);
        s3.enroll(c3);

        school.showStudents();

        s1.viewCourses();
        s2.viewCourses();
        s3.viewCourses();

        c1.showStudents();
        c2.showStudents();
        c3.showStudents();
    }
}

