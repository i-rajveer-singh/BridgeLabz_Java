package inheritance;


/*
 This program demonstrates single inheritance using a library system.
 It models a Book as the base class and Author as a derived class.
 The subclass extends the base class with additional details.
 The example focuses on understanding simple inheritance.
*/

class BaseBook {
    String title;
    int publicationYear;

    BaseBook(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() { // displays basic book information
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Author subclass extending Book with extra details
class AuthorBook extends BaseBook {
    String name;
    String bio;

    AuthorBook(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() { // displays book along with author information
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class to test single inheritance
public class LibraryInheritance {

    public static void main(String[] args) { // program execution starts here
        BaseBook book = new AuthorBook(
                "Object Oriented Programming",
                2022,
                "John Doe",
                "Software engineer and technical author"
        );

        book.displayInfo();
    }
}

