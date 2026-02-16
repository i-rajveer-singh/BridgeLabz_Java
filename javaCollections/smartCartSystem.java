package collections;
/*
 * SmartCartSystem manages shopping items using HashMap for price lookup,
 * LinkedHashMap for preserving insertion order, and TreeMap to display
 * products sorted by price.
 */

import java.util.*;

public class SmartCartSystem {

    private Map<String, Double> priceStore = new HashMap<>();
    private Map<String, Double> cartOrder = new LinkedHashMap<>();

    // Adds product with price
    public void addProduct(String product, double price) {
        priceStore.put(product, price);
    }

    // Adds item to cart while preserving order
    public void addToCart(String product) {
        if (priceStore.containsKey(product))
            cartOrder.put(product, priceStore.get(product));
    }

    // Displays items sorted by price
    public void displaySortedByPrice() {

        TreeMap<Double, List<String>> sorted = new TreeMap<>();

        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            sorted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey()); // Group items with same price
        }

        sorted.forEach((price, items) ->
                items.forEach(item -> System.out.println(item + " -> $" + price)));
    }

    // Displays cart in insertion order
    public void displayCart() {
        cartOrder.forEach((k,v) -> System.out.println(k + " -> $" + v));
    }

    // Entry point
    public static void main(String[] args) {

        SmartCartSystem cart = new SmartCartSystem();

        cart.addProduct("Laptop", 75000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1500);

        cart.addToCart("Mouse");
        cart.addToCart("Laptop");
        cart.addToCart("Keyboard");

        System.out.println("Cart Order:");
        cart.displayCart();

        System.out.println("\nSorted by Price:");
        cart.displaySortedByPrice();
    }
}
