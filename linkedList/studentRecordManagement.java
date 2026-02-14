package linkedlist;

/*
 * StudentLinkedList manages student records using a singly linked list.
 * It supports insertion at different positions, deletion, searching,
 * updating grades, and displaying all records.
 * Demonstrates dynamic memory usage and pointer linking without arrays.
 */

import java.util.Scanner;

// Node class representing each student
class Student {
    int rollNo;
    String name;
    int age;
    String grade;
    Student next; // reference to next node

    Student(int rollNo, String name, int age, String grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null; // important: last node should point to null
    }
}

// Linked List class
class StudentLinkedList {

    private Student head; // starting node of the list

    // Inserts a student at the beginning
    public void addAtBeginning(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);
        newStudent.next = head; // important: link new node before shifting head
        head = newStudent;
        System.out.println("Student added at beginning.");
    }

    // Inserts a student at the end
    public void addAtEnd(int rollNo, String name, int age, String grade) {
        Student newStudent = new Student(rollNo, name, age, grade);

        if (head == null) { // important: handles empty list
            head = newStudent;
            return;
        }

        Student temp = head;
        while (temp.next != null) { // traverse till last node
            temp = temp.next;
        }

        temp.next = newStudent; // important: attach new node
        System.out.println("Student added at end.");
    }

    // Inserts a student at a specific position
    public void addAtPosition(int pos, int rollNo, String name, int age, String grade) {

        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }

        Student newStudent = new Student(rollNo, name, age, grade);
        Student temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next; // move to node before desired position
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newStudent.next = temp.next; // important: preserve remaining chain
        temp.next = newStudent;
        System.out.println("Student added at position " + pos);
    }

    // Deletes a student by roll number
    public void deleteByRoll(int rollNo) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.rollNo == rollNo) {
            head = head.next; // important: deleting first node requires head shift
            System.out.println("Student deleted.");
            return;
        }

        Student temp = head;

        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Student not found.");
            return;
        }

        temp.next = temp.next.next; // important: bypass the node to remove it
        System.out.println("Student deleted.");
    }

    // Searches for a student using roll number
    public void search(int rollNo) {

        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println("Roll: " + temp.rollNo +
                        ", Name: " + temp.name +
                        ", Age: " + temp.age +
                        ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Updates grade of a student
    public void updateGrade(int rollNo, String newGrade) {

        Student temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade; // important: directly modify node data
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student not found.");
    }

    // Displays all student records
    public void display() {

        if (head == null) {
            System.out.println("No records available.");
            return;
        }

        Student temp = head;

        while (temp != null) {
            System.out.println("Roll: " + temp.rollNo +
                    ", Name: " + temp.name +
                    ", Age: " + temp.age +
                    ", Grade: " + temp.grade);
            temp = temp.next; // move forward in list
        }
    }
}

// Main driver class
public class StudentRecordManagement {

    // Entry point of the program
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList(); // important: create linked list object

        while (true) {

            System.out.println("\n---- Student Record Menu ----");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Delete by Roll Number");
            System.out.println("5. Search by Roll Number");
            System.out.println("6. Update Grade");
            System.out.println("7. Display Records");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // important: clears newline buffer

            switch (choice) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine();

                    if (choice == 1)
                        list.addAtBeginning(roll, name, age, grade);
                    else if (choice == 2)
                        list.addAtEnd(roll, name, age, grade);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(pos, roll, name, age, grade);
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    list.deleteByRoll(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Roll No to search: ");
                    list.search(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Grade: ");
                    String g = sc.nextLine();
                    list.updateGrade(r, g);
                    break;

                case 7:
                    list.display();
                    break;

                case 8: 
                    System.out.println("Exiting program...");
                    sc.close(); // important: prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
