/*
 * Student class stores student information
 * It is used to manage student records
 * Helps in handling basic student operations
 */

class Student {

    static String universityName = "SRM University";
    private static int totalStudents = 0;

    final int rollNumber;

    String name;
    String grade;

    // Constructor
    Student(String name, int rollNumber, String grade){
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    // Display student details
    void displayDetails(){
        System.out.println("\n----- Student Details -----");
        System.out.println("University Name : " + universityName);
        System.out.println("Name            : " + name);
        System.out.println("Roll Number     : " + rollNumber);
        System.out.println("Grade           : " + grade);
    }

    // Update student grade
    void updateGrade(String newGrade){
        this.grade = newGrade;
    }

    // Display total students
    static void displayTotalStudents(){
        System.out.println("\nTotal Students : " + totalStudents);
    }

    // Main method
    public static void main(String[] args){

        Student s1 = new Student("Aaditya", 301, "A");

        // instanceof check
        if(s1 instanceof Student){
            s1.displayDetails();
            s1.updateGrade("A+");
        }

        Student s2 = new Student("Siya", 302, "B");

        if(s2 instanceof Student){
            s2.displayDetails();
        }

        Student.displayTotalStudents();
    }
}
