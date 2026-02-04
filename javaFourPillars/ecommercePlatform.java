package fourpillars;


/*
 * UniqueECommercePlatform models an e-commerce system using abstraction,
 * interfaces, encapsulation, and polymorphism. It supports multiple product
 * types, applies tax and discounts, and calculates the final payable price.
 */

import java.util.*;

// Interface for taxable products
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract base class for all products
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Forces subclasses to define discount logic
    public abstract double calculateDiscount();

    // Calculates final price using polymorphism and interface check
    public void printFinalPrice() {
        double tax = 0;

        // Only taxable products calculate tax
        if (this instanceof Taxable) {
            tax = ((Taxable) this).calculateTax();
        }

        double finalPrice = price + tax - calculateDiscount();

        System.out.println("Product: " + name);
        System.out.println("Base Price: " + price);
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Tax: " + tax);
        System.out.println("Final Price: " + finalPrice);
        System.out.println("----------------------");
    }

    // Getters and setters ensure encapsulation
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price > 0) { // Prevent invalid price updates
            this.price = price;
        }
    }
}

// Electronics have higher tax and moderate discount
class Electronics extends Product implements Taxable {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18% GST";
    }
}

// Clothing has lower tax and higher discount
class Clothing extends Product implements Taxable {
    public Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5% GST";
    }
}

// Groceries are essential items with discount but no tax
class Groceries extends Product {
    public Groceries(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Unique main class name to avoid conflicts
public class ECommercePlatform {
    public static void main(String[] args) {

        // Polymorphism: storing different product types in Product reference
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(201, "Laptop", 70000));
        products.add(new Clothing(202, "Jacket", 4000));
        products.add(new Groceries(203, "Rice Bag", 1500));

        // Runtime polymorphism ensures correct discount/tax calculation
        for (Product product : products) {
            product.printFinalPrice();
        }
    }
}
