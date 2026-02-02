package inheritance;

/*
 This program demonstrates hybrid inheritance using a restaurant system.
 It combines class inheritance with interface implementation.
 Person acts as a base class, while Worker provides additional behavior.
 The example shows how Java simulates multiple inheritance.
*/

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

// Worker interface defining common work behavior
interface Worker {
    void performDuties(); // performs assigned duties
}

// Chef subclass inheriting Person and implementing Worker
class ChefRole extends Person implements Worker {

    ChefRole(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() { // chef-specific duties
        System.out.println("Chef is preparing and cooking food");
    }
}

// Waiter subclass inheriting Person and implementing Worker
class WaiterRole extends Person implements Worker {

    WaiterRole(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() { // waiter-specific duties
        System.out.println("Waiter is serving food to customers");
    }
}

// Main class to test hybrid inheritance
public class RestaurantHybrid {

    public static void main(String[] args) { // program execution starts here
        Worker w1 = new ChefRole("Rahul", 201);
        Worker w2 = new WaiterRole("Amit", 202);

        w1.performDuties();
        w2.performDuties();
    }
}
