package linkedlist;

/*
 * TextEditorHistory implements undo/redo functionality
 * using a doubly linked list. Each node represents a text state.
 * Maintains a fixed history size and supports navigation
 * through previous and next states.
 */

import java.util.Scanner;

// Node representing each text state
class TextState {
    String content;
    TextState next; // redo pointer
    TextState prev; // undo pointer

    TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List for history
class TextEditorHistory {

    private TextState head; // oldest state
    private TextState tail; // latest state
    private TextState current; // current editor position
    private int size = 0;
    private final int MAX_HISTORY = 10; // fixed limit

    // Add new text state
    public void addState(String content) {

        TextState newState = new TextState(content);

        // if user types after undo, remove forward history
        if (current != null && current.next != null) {
            current.next = null;
            tail = current;
            size = countSize(); // recalculate size safely
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // remove oldest state if limit exceeded
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("New state added.");
    }

    // Undo operation
    public void undo() {

        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }

        current = current.prev; // move backward
        System.out.println("Undo successful.");
        displayCurrent();
    }

    // Redo operation
    public void redo() {

        if (current == null || current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }

        current = current.next; // move forward
        System.out.println("Redo successful.");
        displayCurrent();
    }

    // Display current text
    public void displayCurrent() {

        if (current == null) {
            System.out.println("Editor is empty.");
            return;
        }

        System.out.println("Current Text: " + current.content);
    }

    // Helper to count nodes (used after trimming forward history)
    private int countSize() {

        int count = 0;
        TextState temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // Display full history (optional but useful)
    public void displayHistory() {

        if (head == null) {
            System.out.println("No history available.");
            return;
        }

        TextState temp = head;

        while (temp != null) {

            if (temp == current)
                System.out.println("-> " + temp.content + " (Current)");
            else
                System.out.println(temp.content);

            temp = temp.next;
        }
    }
}

// Main driver class
public class UndoRedoTextEditor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TextEditorHistory editor = new TextEditorHistory(); // create history manager

        while (true) {

            System.out.println("\n---- Text Editor Menu ----");
            System.out.println("1. Type / Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("6. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter text: ");
                    editor.addState(sc.nextLine());
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrent();
                    break;

                case 5:
                    editor.displayHistory();
                    break;

                case 6:
                    System.out.println("Exiting editor...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
