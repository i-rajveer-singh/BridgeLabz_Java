package objectmodelling;
import java.util.ArrayList;

/*
 * This program demonstrates object relationships in an E-commerce system.
 * Customer places Orders (association + communication).
 * Order aggregates Product objects (aggregation).
 * Orders act as the communication medium between Customer and Products.
 */

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getDetails() {
        return name + " (" + price + ")";
    }

    public double getPrice() {
        return price;
    }
}
//This is order class which contains detail of order
class Order {
    private String orderId;
    private ArrayList<Product> products;

    public Order(String orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrder() {
        System.out.println("\nOrder ID: " + orderId);
        double total = 0;

        for (Product p : products) {
            System.out.println("Product: " + p.getDetails());
            total += p.getPrice();
        }

        System.out.println("Total Amount: ₹" + total);
    }
}
//This is customer class which contains detail of customer
class EcommerceCustomer {
    private String name;
    private ArrayList<Order> orders;

    public EcommerceCustomer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("\n" + name + " placed a new order.");
    }

    public void showOrders() {
        System.out.println("\nOrders of " + name + ":");
        for (Order o : orders) {
            o.showOrder();
        }
    }
}
//from here execution of main
public class EcommercePlatform {
    public static void main(String[] args) {

        EcommerceCustomer c1 = new EcommerceCustomer("Aaditya");

        Product p1 = new Product("Laptop", 65000);
        Product p2 = new Product("Mouse", 1200);
        Product p3 = new Product("Keyboard", 2500);

        Order o1 = new Order("ORD101");
        Order o2 = new Order("ORD102");

        o1.addProduct(p1);
        o1.addProduct(p2);

        o2.addProduct(p3);

        c1.placeOrder(o1);
        c1.placeOrder(o2);

        c1.showOrders();
    }
}
