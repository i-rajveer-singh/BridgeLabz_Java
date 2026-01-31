package accessmodifiers;

import java.util.Scanner;

/*
 * This program demonstrates access modifiers in Java.
 * It shows public, protected, and private variables
 * along with inheritance and encapsulation using getter/setter methods.
 */

class BankAccount {

    public int accountNumber;        // public variable
    protected String accountHolder;  // protected variable
    private double balance;          // private variable

    // Sets value for private balance
    public void setBalance(double b) {
        balance = b;
    }

    // Returns value of private balance
    public double getBalance() {
        return balance;
    }

    // Main method to take input and demonstrate access control
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SavingsAccount s = new SavingsAccount();

        System.out.print("Account Number: ");
        s.accountNumber = sc.nextInt();
        sc.nextLine();

        System.out.print("Account Holder: ");
        s.accountHolder = sc.nextLine();

        System.out.print("Balance: ");
        double b = sc.nextDouble();
        s.setBalance(b);

        s.display();
        System.out.println("Balance: " + s.getBalance());
    }
}

/*
 * This class extends BankAccount.
 * It accesses public and protected members using inheritance.
 */

class SavingsAccount extends BankAccount {

    // Displays inherited account details
    void display() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
    }
}
