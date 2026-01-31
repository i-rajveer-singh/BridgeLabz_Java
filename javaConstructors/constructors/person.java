package Level1;

import java.util.Scanner;

/*
 * This class represents a Person entity.
 * It uses a parameterized constructor and a copy constructor
 * with Scanner input to duplicate person details.
 */

class Person {

    private String name;
    private int age;

    // Initializes person details using constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Initializes person using copy constructor
    Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    // Displays person name and age
    void display() {
        System.out.println(name + " - " + age);
    }

    // Main method to take input and demonstrate copy constructor
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String n = sc.nextLine();
        System.out.print("Enter age: ");
        int a = sc.nextInt();

        Person p1 = new Person(n, a);
        Person p2 = new Person(p1);

        p1.display();
        p2.display();
    }
}
