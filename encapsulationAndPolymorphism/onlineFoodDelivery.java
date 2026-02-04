package fourpillars;

/*
 * UniqueFoodDispatch models an online food delivery system using abstraction,
 * encapsulation, interfaces, and polymorphism. It processes multiple food
 * items, applies discounts, and calculates final order prices securely.
 */

import java.util.*;

// Interface defining discount behavior
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract base class for all food items
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Forces subclasses to define pricing logic
    public abstract double calculateTotalPrice();

    // Displays item details
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + calculateTotalPrice());
        System.out.println("----------------------");
    }

    // Getters maintain controlled access
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) {
        if (quantity > 0) { // Prevent invalid quantity updates
            this.quantity = quantity;
        }
    }
}

// Veg items with standard discount
class VegItem extends FoodItem implements Discountable {

    public VegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - applyDiscount();
    }

    @Override
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "Veg Discount: 5%";
    }
}

// Non-veg items include extra handling charge
class NonVegItem extends FoodItem implements Discountable {

    public NonVegItem(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double total = (getPrice() * getQuantity()) + 50; // Extra charge
        return total - applyDiscount();
    }

    @Override
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * 0.03; // Smaller discount
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg Discount: 3% with ₹50 handling charge";
    }
}

// Unique main class name to avoid conflicts
public class FoodDispatch {

    // Processes all food items using polymorphism
    public static void processOrder(List<FoodItem> order) {
        double grandTotal = 0;

        for (FoodItem item : order) {
            item.getItemDetails();
            grandTotal += item.calculateTotalPrice();
        }

        System.out.println("Grand Total: " + grandTotal);
    }

    public static void main(String[] args) {

        // Polymorphism: storing different food types in FoodItem reference
        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));
        order.add(new VegItem("Veg Fried Rice", 180, 3));

        processOrder(order);
    }
}

