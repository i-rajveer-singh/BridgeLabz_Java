package linkedlist;

/*
 * InventoryLinkedList manages inventory items using a singly linked list.
 * Supports insertion, deletion, searching, updating quantity,
 * sorting, and calculating total inventory value.
 */

import java.util.Scanner;

// Node class representing each inventory item
class Item {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Item next; // pointer to next node

    Item(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

// Linked List class
class InventoryLinkedList {

    private Item head; // start of list

    // Add item at beginning
    public void addAtBeginning(int id, String name, int qty, double price) {

        Item newItem = new Item(id, name, qty, price);
        newItem.next = head; // link before shifting head
        head = newItem;

        System.out.println("Item added at beginning.");
    }

    // Add item at end
    public void addAtEnd(int id, String name, int qty, double price) {

        Item newItem = new Item(id, name, qty, price);

        if (head == null) { // empty list case
            head = newItem;
            return;
        }

        Item temp = head;

        while (temp.next != null) {
            temp = temp.next; // traverse to last node
        }

        temp.next = newItem; // attach new node
        System.out.println("Item added at end.");
    }

    // Add item at specific position
    public void addAtPosition(int pos, int id, String name, int qty, double price) {

        if (pos <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        if (pos == 1) {
            addAtBeginning(id, name, qty, price);
            return;
        }

        Item newItem = new Item(id, name, qty, price);
        Item temp = head;

        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next; // move to node before position
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newItem.next = temp.next; // preserve chain
        temp.next = newItem;

        System.out.println("Item added at position " + pos);
    }

    // Remove item by ID
    public void removeById(int id) {

        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.itemId == id) {
            head = head.next; // shift head
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;

        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item not found.");
            return;
        }

        temp.next = temp.next.next; // bypass node
        System.out.println("Item removed.");
    }

    // Update quantity
    public void updateQuantity(int id, int newQty) {

        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty; // directly update data
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // Search by ID
    public void searchById(int id) {

        Item temp = head;

        while (temp != null) {
            if (temp.itemId == id) {
                printItem(temp);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Item not found.");
    }

    // Search by Name
    public void searchByName(String name) {

        Item temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                printItem(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found)
            System.out.println("Item not found.");
    }

    // Calculate total inventory value
    public void totalInventoryValue() {

        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.price * temp.quantity; // accumulate value
            temp = temp.next;
        }

        System.out.println("Total Inventory Value: " + total);
    }

    // Sort inventory using Bubble Sort (swap data for simplicity)
    public void sortByName(boolean ascending) {

        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = head; j.next != null; j = j.next) {

                int cmp = j.itemName.compareToIgnoreCase(j.next.itemName);

                if ((ascending && cmp > 0) || (!ascending && cmp < 0)) {
                    swapData(j, j.next); // swap node data instead of pointers
                }
            }
        }

        System.out.println("Inventory sorted by name.");
    }

    public void sortByPrice(boolean ascending) {

        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = head; j.next != null; j = j.next) {

                if ((ascending && j.price > j.next.price) ||
                        (!ascending && j.price < j.next.price)) {
                    swapData(j, j.next);
                }
            }
        }

        System.out.println("Inventory sorted by price.");
    }

    // Helper method to swap node data
    private void swapData(Item a, Item b) {

        int id = a.itemId;
        String name = a.itemName;
        int qty = a.quantity;
        double price = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = id;
        b.itemName = name;
        b.quantity = qty;
        b.price = price;
    }

    // Display all items
    public void display() {

        if (head == null) {
            System.out.println("No inventory records.");
            return;
        }

        Item temp = head;

        while (temp != null) {
            printItem(temp);
            temp = temp.next;
        }
    }

    // Helper method to print item
    private void printItem(Item i) {
        System.out.println("ID: " + i.itemId +
                ", Name: " + i.itemName +
                ", Quantity: " + i.quantity +
                ", Price: " + i.price);
    }
}

// Main driver class
public class InventoryManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InventoryLinkedList list = new InventoryLinkedList(); // create list object

        while (true) {

            System.out.println("\n---- Inventory Menu ----");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Position");
            System.out.println("4. Remove by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Total Inventory Value");
            System.out.println("9. Sort by Name");
            System.out.println("10. Sort by Price");
            System.out.println("11. Display");
            System.out.println("12. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // clears buffer

            switch (choice) {

                case 1:
                case 2:
                case 3:

                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    if (choice == 1)
                        list.addAtBeginning(id, name, qty, price);
                    else if (choice == 2)
                        list.addAtEnd(id, name, qty, price);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        list.addAtPosition(pos, id, name, qty, price);
                    }
                    break;

                case 4:
                    System.out.print("Enter Item ID: ");
                    list.removeById(sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter Item ID: ");
                    int uid = sc.nextInt();

                    System.out.print("Enter New Quantity: ");
                    int newQty = sc.nextInt();

                    list.updateQuantity(uid, newQty);
                    break;

                case 6:
                    System.out.print("Enter Item ID: ");
                    list.searchById(sc.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Item Name: ");
                    list.searchByName(sc.nextLine());
                    break;

                case 8:
                    list.totalInventoryValue();
                    break;

                case 9:
                    System.out.print("Ascending? (true/false): ");
                    list.sortByName(sc.nextBoolean());
                    break;

                case 10:
                    System.out.print("Ascending? (true/false): ");
                    list.sortByPrice(sc.nextBoolean());
                    break;

                case 11:
                    list.display();
                    break;

                case 12:
                    System.out.println("Exiting program...");
                    sc.close(); // prevents resource leak
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

