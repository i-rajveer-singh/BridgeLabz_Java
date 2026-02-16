package generics;
/*
 * DynamicMarketplaceCore implements a type-safe product catalog using generics.
 * It supports multiple product categories like Books, Clothing, and Gadgets.
 * Bounded type parameters restrict valid categories while generic methods
 * allow dynamic discount application across all product types.
 */

import java.util.*;

// Marker interface for all product categories
interface ProductCategory {
    // Returns category name
    String getCategoryName();
}

// Book category
class BookCategory implements ProductCategory {
    public String getCategoryName() {
        return "Books";
    }
}

// Clothing category
class ClothingCategory implements ProductCategory {
    public String getCategoryName() {
        return "Clothing";
    }
}

// Gadget category
class GadgetCategory implements ProductCategory {
    public String getCategoryName() {
        return "Gadgets";
    }
}

// Generic Product class restricted to valid categories
class Product<T extends ProductCategory> {
    private String productName;
    private double price;
    private T category;

    public Product(String productName, double price, T category) {
        this.productName = productName;
        this.price = price;
        this.category = category;
    }

    // Returns product name
    public String getProductName() {
        return productName;
    }

    // Returns product price
    public double getPrice() {
        return price;
    }

    // Updates product price after discount
    public void setPrice(double price) {
        this.price = price;
    }

    // Returns product category
    public T getCategory() {
        return category;
    }

    // Provides formatted product details
    public String getDetails() {
        return productName + " | Category: " + category.getCategoryName() + " | Price: " + price;
    }
}

// Catalog that can store any type of Product
class ProductCatalog {
    private List<Product<? extends ProductCategory>> catalog = new ArrayList<>();

    // Adds products safely into catalog
    public void addProduct(Product<? extends ProductCategory> product) {
        catalog.add(product);
    }

    // Displays all products regardless of category
    public void displayCatalog() {
        for (Product<? extends ProductCategory> product : catalog) {
            System.out.println(product.getDetails());
        }
    }

    // Generic method to apply discount dynamically
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discountAmount);
    }
}

// Driver class
public class DynamicMarketplaceCore {

    // Entry point of the program
    public static void main(String[] args) {

        Product<BookCategory> book = new Product<>("Java Generics Guide", 599, new BookCategory());
        Product<ClothingCategory> tshirt = new Product<>("Cotton T-Shirt", 999, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 45000, new GadgetCategory());

        ProductCatalog catalog = new ProductCatalog();

        catalog.addProduct(book);
        catalog.addProduct(tshirt);
        catalog.addProduct(phone);

        // Applying discounts
        ProductCatalog.applyDiscount(book, 10);
        ProductCatalog.applyDiscount(phone, 5);

        System.out.println("=== Product Catalog ===");
        catalog.displayCatalog();
    }
}
