package objectmodelling;

import java.util.ArrayList;
import java.util.List;

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println("Account opened for " + customer.getName() + " at " + bankName);
    }
}

class Customer {
    private String name;
    private double balance;

    public Customer(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
    }

    public String getName() { return name; }

    public void viewBalance() {
        System.out.println(name + "'s current balance: " + balance);
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }
}

public class BankAssociation {
    public static void main(String[] args) {
        // Create the Bank
        Bank chase = new Bank("HDFC BANK");

        // Create the Customer
        Customer alice = new Customer("Aaditya", 500.0);

        // Establishing the Association
        chase.openAccount(alice);

        // Communication
        alice.viewBalance();
    }
}