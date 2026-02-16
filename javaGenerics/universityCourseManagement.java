package generics;
/*
 * UniCourseMatrix demonstrates a multi-level university course system using generics.
 * It manages different evaluation types like Exam, Assignment, and Research courses.
 * Bounded type parameters ensure only valid course types are used, while
 * wildcards allow flexible handling of mixed course collections.
 */

import java.util.*;

// Base abstract class representing evaluation type
abstract class CourseType {
    private String evaluationMethod;

    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    // Returns evaluation method
    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    // Ensures each course type provides its details
    public abstract String getDetails();
}

// Exam-based course
class ExamCourse extends CourseType {
    private int examWeightage;

    public ExamCourse(int examWeightage) {
        super("Exam-Based");
        this.examWeightage = examWeightage;
    }

    // Provides formatted exam course details
    public String getDetails() {
        return getEvaluationMethod() + " | Exam Weightage: " + examWeightage + "%";
    }
}

// Assignment-based course
class AssignmentCourse extends CourseType {
    private int assignmentCount;

    public AssignmentCourse(int assignmentCount) {
        super("Assignment-Based");
        this.assignmentCount = assignmentCount;
    }

    // Provides formatted assignment course details
    public String getDetails() {
        return getEvaluationMethod() + " | Assignments: " + assignmentCount;
    }
}

// Research-based course
class ResearchCourse extends CourseType {
    private String researchArea;

    public ResearchCourse(String researchArea) {
        super("Research-Based");
        this.researchArea = researchArea;
    }

    // Provides formatted research course details
    public String getDetails() {
        return getEvaluationMethod() + " | Research Area: " + researchArea;
    }
}

// Generic course class restricted to CourseType
class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    // Returns course name
    public String getCourseName() {
        return courseName;
    }

    // Returns course type
    public T getCourseType() {
        return courseType;
    }

    // Provides formatted course details
    public String getDetails() {
        return courseName + " | " + courseType.getDetails();
    }
}

// Manager class to handle courses dynamically
class CourseManager {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    // Adds any valid course safely
    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    // Displays courses using wildcard flexibility
    public void displayCourses(List<? extends CourseType> types) {
        for (CourseType type : types) {
            System.out.println(type.getDetails());
        }
    }

    // Displays full course catalog
    public void displayAllCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course.getDetails());
        }
    }
}

// Driver class
public class UniCourseMatrix {

    // Entry point of the program
    public static void main(String[] args) {

        Course<ExamCourse> dsa = new Course<>("Data Structures", new ExamCourse(70));
        Course<AssignmentCourse> webDev = new Course<>("Web Development", new AssignmentCourse(5));
        Course<ResearchCourse> aiResearch = new Course<>("AI Research", new ResearchCourse("Deep Learning"));

        CourseManager manager = new CourseManager();

        manager.addCourse(dsa);
        manager.addCourse(webDev);
        manager.addCourse(aiResearch);

        System.out.println("=== University Course Catalog ===");
        manager.displayAllCourses();

        // Demonstrating wildcard with direct course types
        List<ExamCourse> examList = Arrays.asList(new ExamCourse(60), new ExamCourse(80));
        System.out.println("\n=== Exam Evaluation Types ===");
        manager.displayCourses(examList);
    }
}
