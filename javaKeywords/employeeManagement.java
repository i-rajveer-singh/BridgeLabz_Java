/*
 * Employee class is used to manage employee details
 * It stores personal information and company data
 * Supports employee creation and information display
 */

class Employee {

    static String companyName = "PeerIslands India Pvt Ltd";
    private static int totalEmployees = 0;

    final int id;

    String name;
    String designation;

    // Constructor
    Employee(String name, int id, String designation){
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }

    // Display employee details
    void displayDetails(){
        System.out.println("\n----- Employee Details -----");
        System.out.println("Company Name : " + companyName);
        System.out.println("Name         : " + name);
        System.out.println("ID           : " + id);
        System.out.println("Designation  : " + designation);
    }

    // Display total employees
    static void displayTotalEmployees(){
        System.out.println("\nTotal Employees : " + totalEmployees);
    }

    // Main method
    public static void main(String[] args){

        Employee e1 = new Employee("Aaditya", 101, "Software Engineer");

        // instanceof check
        if(e1 instanceof Employee){
            e1.displayDetails();
        }

        Employee e2 = new Employee("Rahul", 102, "Data Analyst");

        Employee.displayTotalEmployees();
    }
}
