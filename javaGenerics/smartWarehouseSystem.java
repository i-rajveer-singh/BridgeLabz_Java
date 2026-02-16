package generics;
/*
 * SmartWarehouseHub demonstrates a type-safe warehouse system using Java Generics.
 * It stores different WarehouseItem types like Electronics, Groceries, and Furniture.
 * Bounded type parameters ensure only valid items are stored.
 * Wildcards allow displaying items from any storage without losing flexibility.
 */

import java.util.*;

// Base abstract class for all warehouse items
abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Returns item name
    public String getName() {
        return name;
    }

    // Returns item price
    public double getPrice() {
        return price;
    }

    // Ensures each item provides its details
    public abstract String getDetails();
}

// Electronics item type
class Electronics extends WarehouseItem {
    private int warrantyMonths;

    public Electronics(String name, double price, int warrantyMonths) {
        super(name, price);
        this.warrantyMonths = warrantyMonths;
    }

    // Provides formatted electronics details
    public String getDetails() {
        return "Electronics: " + getName() + ", Price: " + getPrice() +
                ", Warranty: " + warrantyMonths + " months";
    }
}

// Groceries item type
class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    // Provides formatted grocery details
    public String getDetails() {
        return "Grocery: " + getName() + ", Price: " + getPrice() +
                ", Expiry: " + expiryDate;
    }
}

// Furniture item type
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    // Provides formatted furniture details
    public String getDetails() {
        return "Furniture: " + getName() + ", Price: " + getPrice() +
                ", Material: " + material;
    }
}

// Generic storage that only accepts WarehouseItem or its subclasses
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    // Adds an item safely to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Retrieves all stored items
    public List<T> getItems() {
        return items;
    }
}

// Main driver class
public class SmartWarehouseHub {

    // Displays items from any storage using wildcard
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getDetails());
        }
    }

    // Entry point of the program
    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 75000, 24));
        groceriesStorage.addItem(new Groceries("Rice Bag", 1200, "12-12-2026"));
        furnitureStorage.addItem(new Furniture("Office Chair", 4500, "Mesh"));

        System.out.println("=== Electronics Storage ===");
        displayItems(electronicsStorage.getItems());

        System.out.println("\n=== Groceries Storage ===");
        displayItems(groceriesStorage.getItems());

        System.out.println("\n=== Furniture Storage ===");
        displayItems(furnitureStorage.getItems());
    }
}
