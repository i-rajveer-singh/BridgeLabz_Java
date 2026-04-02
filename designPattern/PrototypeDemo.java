package designpattern;

// 1. Employee Class
class Employee implements Cloneable {

    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // 2. Override clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();  // shallow copy
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
    }
}


// 3. Main Class
public class PrototypeDemo {

    public static void main(String[] args) {

        try {
            // 4. Create original object
            Employee emp1 = new Employee("Prajwal", "AI Research", 50000);

            // 5. Clone the object
            Employee emp2 = (Employee) emp1.clone();

            System.out.println("Original Employee:");
            emp1.display();

            System.out.println("\nCloned Employee:");
            emp2.display();

            // Verify they are different objects
            System.out.println("\nAre objects same? " + (emp1 == emp2));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
