package instancevsclass;

import java.util.Scanner;

/*
 * This class demonstrates instance and class variables.
 * It uses a static variable to count total products
 * and instance variables to store product details.
 */

class Product {

    String productName;   // instance variable
    double price;         // instance variable
    static int totalProducts = 0; // class variable

    // Initializes product details and updates product count
    Product(String name, double price) {
        this.productName = name;
        this.price = price;
        totalProducts++;
    }

    // Displays product name and price
    void displayProductDetails() {
        System.out.println(productName + " - " + price);
    }

    // Displays total number of products
    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    // Main method to take input and demonstrate instance vs class variables
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Product name: ");
        String n = sc.nextLine();
        System.out.print("Price: ");
        double p = sc.nextDouble();

        Product prod = new Product(n, p);
        prod.displayProductDetails();
        Product.displayTotalProducts();
    }
}
