package fourpillars;

/*
 * UniqueBankingCore models a banking system using abstraction,
 * encapsulation, interfaces, and polymorphism. It supports multiple
 * account types, handles transactions securely, and calculates interest dynamically.
 */

import java.util.*;

// Interface defining loan-related behavior
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract base class for all bank accounts
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Common deposit method
    public void deposit(double amount) {
        if (amount > 0) { // Prevent invalid deposits
            balance += amount;
        }
    }

    // Basic withdrawal with balance validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Withdrawal failed: Insufficient balance.");
        }
    }

    // Forces subclasses to define interest logic
    public abstract double calculateInterest();

    // Displays account summary with interest
    public void displayAccount() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
        System.out.println("Interest: " + calculateInterest());
        System.out.println("----------------------");
    }

    // Getters ensure controlled access
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }

    protected void setBalance(double balance) {
        this.balance = balance;
    }
}

// Savings account with higher interest
class SavingsAccount extends BankAccount implements Loanable {

    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan approved for Savings Account: " + amount);
        } else {
            System.out.println("Loan denied for Savings Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 20000; // Minimum balance rule
    }
}

// Current account with minimal interest but overdraft facility
class CurrentAccount extends BankAccount implements Loanable {

    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.01; // 1% interest
    }

    @Override
    public void applyForLoan(double amount) {
        if (calculateLoanEligibility()) {
            System.out.println("Loan approved for Current Account: " + amount);
        } else {
            System.out.println("Loan denied for Current Account.");
        }
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 50000; // Higher requirement
    }
}

// Unique main class name to avoid conflicts
public class BankingCore {
    public static void main(String[] args) {

        // Polymorphism: storing different account types in BankAccount reference
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount acc1 = new SavingsAccount("SB1001", "Aaditya", 30000);
        CurrentAccount acc2 = new CurrentAccount("CA2001", "Siya", 60000);

        accounts.add(acc1);
        accounts.add(acc2);

        acc1.deposit(5000);
        acc2.withdraw(10000);

        // Runtime polymorphism ensures correct interest calculation
        for (BankAccount acc : accounts) {
            acc.displayAccount();
        }

        // Demonstrating loan functionality
        acc1.applyForLoan(100000);
        acc2.applyForLoan(200000);
    }
}

