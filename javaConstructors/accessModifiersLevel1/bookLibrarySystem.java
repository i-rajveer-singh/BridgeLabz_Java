package accessmodifiers;

import java.util.Scanner;

/*
 * This program demonstrates access modifiers in Java.
 * It shows public, protected, and private variables
 * along with inheritance and getter/setter usage.
 */

class Book {

    public String ISBN;        // public variable
    protected String title;    // protected variable
    private String author;     // private variable

    // Sets value for private author
    public void setAuthor(String a) {
        author = a;
    }

    // Returns value of private author
    public String getAuthor() {
        return author;
    }

    // Main method to take input and demonstrate access control
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EBook e = new EBook();

        System.out.print("ISBN: ");
        e.ISBN = sc.nextLine();

        System.out.print("Title: ");
        e.title = sc.nextLine();

        System.out.print("Author: ");
        String a = sc.nextLine();
        e.setAuthor(a);

        e.display();
        System.out.println("Author: " + e.getAuthor());
    }
}

/*
 * This class extends Book.
 * It accesses public and protected members using inheritance.
 */

class EBook extends Book {

    // Displays inherited book details
    void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
    }
}
