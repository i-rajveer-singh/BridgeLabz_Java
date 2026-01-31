package Level1;

import java.util.Scanner;

/*
 * This class represents a Circle.
 * It uses constructor chaining to initialize radius
 * and Scanner input to calculate and display area.
 */

class Circle {

    private double radius;

    // Default constructor using constructor chaining
    Circle() {
        this(1.0);
    }

    // Initializes radius using parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Displays radius and calculated area
    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + Math.PI * radius * radius);
    }

    // Main method to take radius input and display result
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius: ");
        double r = sc.nextDouble();

        Circle c = new Circle(r);
        c.display();
    }
}
