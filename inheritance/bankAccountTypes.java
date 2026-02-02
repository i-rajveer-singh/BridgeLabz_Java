package inheritance;

/*
 This program demonstrates hierarchical inheritance in a banking system.
 It models a common BankAccount with multiple specific account types.
 Each subclass inherits shared data and adds unique characteristics.
 The example focuses on organizing related classes efficiently.
*/

class BaseBankAccount {
    int accountNumber;
    double balance;

    BaseBankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayAccountType() { // displays generic account type
        System.out.println("Generic Bank Account");
    }
}

// SavingsAccount subclass with interest feature
class SavingsAccountType extends BaseBankAccount {
    double interestRate;

    SavingsAccountType(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    void displayAccountType() { // displays savings account type
        System.out.println("Savings Account");
    }
}

// CheckingAccount subclass with withdrawal limit
class CheckingAccountType extends BaseBankAccount {
    int withdrawalLimit;

    CheckingAccountType(int accountNumber, double balance, int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    void displayAccountType() { // displays checking account type
        System.out.println("Checking Account");
    }
}

// FixedDepositAccount subclass with lock-in period
class FixedDepositAccountType extends BaseBankAccount {
    int lockInPeriod;

    FixedDepositAccountType(int accountNumber, double balance, int lockInPeriod) {
        super(accountNumber, balance);
        this.lockInPeriod = lockInPeriod;
    }

    @Override
    void displayAccountType() { // displays fixed deposit account type
        System.out.println("Fixed Deposit Account");
    }
}

// Main class to test hierarchical inheritance
public class BankAccountHierarchy {

    public static void main(String[] args) { // program execution starts here
        BaseBankAccount acc1 = new SavingsAccountType(1001, 50000, 4.5);
        BaseBankAccount acc2 = new CheckingAccountType(1002, 30000, 5);
        BaseBankAccount acc3 = new FixedDepositAccountType(1003, 100000, 24);

        acc1.displayAccountType();
        acc2.displayAccountType();
        acc3.displayAccountType();
    }
}

