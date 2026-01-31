/*
 * Product class is used to manage shopping cart items
 * It stores product information and pricing details
 * Supports discount management and item processing
 */

class Product {

    static double discount = 10.0; // shared discount %
    final int productID;

    String productName;
    double price;
    int quantity;

    // Constructor
    Product(String productName, int productID, double price, int quantity){
        this.productName = productName;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    // Display product details
    void displayDetails(){
        double discountedPrice = price - (price * discount / 100);

        System.out.println("\n----- Product Details -----");
        System.out.println("Product Name : " + productName);
        System.out.println("Product ID   : " + productID);
        System.out.println("Price        : " + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Discount %   : " + discount);
        System.out.println("Final Price  : " + discountedPrice);
    }

    // Update discount value
    static void updateDiscount(double newDiscount){
        discount = newDiscount;
    }

    // Main method
    public static void main(String[] args){

        Product p1 = new Product("Laptop", 201, 60000.0, 1);

        // instanceof check
        if(p1 instanceof Product){
            p1.displayDetails();
        }

        Product.updateDiscount(15.0);

        Product p2 = new Product("Headphones", 202, 3000.0, 2);

        if(p2 instanceof Product){
            p2.displayDetails();
        }
    }
}
