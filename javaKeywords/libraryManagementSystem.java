/*
 * Library Management System
 * Demonstrates static, final, this, instanceof
 * Class and object concept example
 */

class Book {

    static String libraryName = "Central Library";
    final String isbn;

    String title;
    String author;

    // Constructor
    Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Display book details
    void displayDetails(){
        System.out.println("\n----- Book Details -----");
        System.out.println("Library Name : " + libraryName);
        System.out.println("Title        : " + title);
        System.out.println("Author       : " + author);
        System.out.println("ISBN         : " + isbn);
    }

    // Display library name
    static void displayLibraryName(){
        System.out.println("\nLibrary Name : " + libraryName);
    }

    // Main method
    public static void main(String[] args){

        Book b1 = new Book("Java Programming", "James Gosling", "ISBN-101");

        // instanceof check
        if(b1 instanceof Book){
            b1.displayDetails();
        }

    }
}

