package linkedlist;

/*
 * TaskCircularLinkedList manages tasks using a circular linked list.
 * Supports insertion, deletion, searching, task navigation,
 * and ensures the last node always points back to the head.
 */

import java.util.Scanner;

// Node class representing each task
class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next; // pointer to next node

    Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

// Circular Linked List class
class TaskCircularLinkedList {

    private Task head; // starting node
    private Task current; // tracks current task for scheduler

    // Add task at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {

        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head; // important: points to itself
            current = head;
        } else {
            Task temp = head;

            while (temp.next != head) { // find last node
                temp = temp.next;
            }

            newTask.next = head;
            temp.next = newTask; // maintain circular link
            head = newTask; // shift head
        }

        System.out.println("Task added at beginning.");
    }

    // Add task at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {

        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            newTask.next = head; // circular self link
            current = head;
        } else {
            Task temp = head;

            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newTask;
            newTask.next = head; // last node must point to head
        }

        System.out.println("Task added at end.");
    }

    // Add task at specific position
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {

        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next; // traverse safely within circle
        }

        newTask.next = temp.next;
        temp.next = newTask; // insert node while preserving loop

        System.out.println("Task added at position " + pos);
    }

    // Remove task by ID
    public void removeById(int id) {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Task temp = head;
        Task prev = null;

        // special case: deleting head
        if (head.taskId == id) {

            if (head.next == head) { // only one node
                head = null;
                current = null;
            } else {
                Task last = head;

                while (last.next != head) {
                    last = last.next;
                }

                head = head.next;
                last.next = head; // restore circular link
                current = head;
            }

            System.out.println("Task removed.");
            return;
        }

        do {
            prev = temp;
            temp = temp.next;
        } while (temp != head && temp.taskId != id);

        if (temp.taskId != id) {
            System.out.println("Task not found.");
            return;
        }

        prev.next = temp.next; // bypass node

        if (current == temp) {
            current = temp.next; // move scheduler pointer
        }

        System.out.println("Task removed.");
    }

    // View current task
    public void viewCurrentTask() {

        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        printTask(current);
    }

    // Move to next task
    public void moveToNextTask() {

        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        current = current.next; // circular move
        System.out.println("Moved to next task:");
        printTask(current);
    }

    // Display all tasks
    public void displayAll() {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;

        do {
            printTask(temp);
            temp = temp.next; // stops when loop completes
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {

        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tasks found with this priority.");
    }

    // Helper method to print task
    private void printTask(Task t) {
        System.out.println("Task ID: " + t.taskId +
                ", Name: " + t.taskName +
                ", Priority: " + t.priority +
                ", Due Date: " + t.dueDate);
    }
}

// Main driver class
public class TaskScheduler {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskCircularLinkedList list = new TaskCircularLinkedList(); // create circular list

        while (true) {

            System.out.println("\n---- Task Scheduler Menu ----");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by Task ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            switch (choice) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Due Date: ");
                    String dueDate = sc.nextLine();

                    if (choice == 1)
                        list.addAtBeginning(id, name, priority, dueDate);
                    else if (choice == 2)
                        list.addAtEnd(id, name, priority, dueDate);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(pos, id, name, priority, dueDate);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    list.removeById(sc.nextInt());
                    break;

                case 5:
                    list.viewCurrentTask();
                    break;

                case 6:
                    list.moveToNextTask();
                    break;

                case 7:
                    list.displayAll();
                    break;

                case 8:
                    System.out.print("Enter Priority: ");
                    list.searchByPriority(sc.nextInt());
                    break;

                case 9:
                    System.out.println("Exiting program...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
