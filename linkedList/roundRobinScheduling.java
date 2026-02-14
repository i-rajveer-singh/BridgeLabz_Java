package linkedlist;

/*
 * RoundRobinScheduler simulates CPU scheduling using a circular linked list.
 * Each node represents a process. Supports adding processes,
 * executing them using time quantum, removing completed processes,
 * and calculating average waiting & turnaround time.
 */

import java.util.Scanner;

// Node class representing each process
class Process {
    int processId;
    int burstTime;
    int remainingTime; // tracks execution progress
    int priority;
    Process next; // pointer to next process

    Process(int id, int burst, int priority) {
        this.processId = id;
        this.burstTime = burst;
        this.remainingTime = burst; // initially equal to burst time
        this.priority = priority;
        this.next = null;
    }
}

// Circular Linked List Scheduler
class RoundRobinCircularList {

    private Process head; // start of queue
    private Process tail; // end of queue

    private int totalWaitingTime = 0;
    private int totalTurnaroundTime = 0;
    private int completedProcesses = 0;

    // Add process at end
    public void addProcess(int id, int burst, int priority) {

        Process newProcess = new Process(id, burst, priority);

        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // maintain circular link
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head; // last must point to head
        }

        System.out.println("Process added.");
    }

    // Remove completed process
    private void removeProcess(Process prev, Process current) {

        if (head == null) return;

        if (head == tail) { // only one process
            head = tail = null;
        }
        else if (current == head) {
            head = head.next;
            tail.next = head; // fix circular link
        }
        else if (current == tail) {
            tail = prev;
            tail.next = head;
        }
        else {
            prev.next = current.next; // bypass node
        }
    }

    // Display processes
    public void displayProcesses() {

        if (head == null) {
            System.out.println("No processes in queue.");
            return;
        }

        Process temp = head;

        do {
            System.out.println("PID: " + temp.processId +
                    ", Remaining Time: " + temp.remainingTime +
                    ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head); // ensures one full loop
    }

    // Simulate round robin scheduling
    public void simulate(int quantum) {

        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        Process current = head;
        Process prev = tail;

        while (head != null) {

            if (current.remainingTime > quantum) {

                time += quantum;
                current.remainingTime -= quantum; // partial execution

                prev = current;
                current = current.next; // move to next process
            }
            else {

                time += current.remainingTime;

                int waitingTime = time - current.burstTime;
                int turnaroundTime = time;

                totalWaitingTime += waitingTime;
                totalTurnaroundTime += turnaroundTime;
                completedProcesses++;

                System.out.println("Process " + current.processId + " completed.");

                removeProcess(prev, current);

                if (head == null) break;

                current = prev.next; // continue from next process
            }

            System.out.println("\nProcesses after this round:");
            displayProcesses();
        }

        // calculate averages
        if (completedProcesses > 0) {
            System.out.println("\nAverage Waiting Time: " +
                    (double) totalWaitingTime / completedProcesses);

            System.out.println("Average Turnaround Time: " +
                    (double) totalTurnaroundTime / completedProcesses);
        }
    }
}

// Main driver class
public class RoundRobinSchedulingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoundRobinCircularList scheduler = new RoundRobinCircularList(); // create scheduler

        while (true) {

            System.out.println("\n---- Round Robin Scheduler ----");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Run Scheduler");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Process ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter Burst Time: ");
                    int burst = sc.nextInt();

                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();

                    scheduler.addProcess(id, burst, priority);
                    break;

                case 2:
                    scheduler.displayProcesses();
                    break;

                case 3:
                    System.out.print("Enter Time Quantum: ");
                    int quantum = sc.nextInt();

                    scheduler.simulate(quantum);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
