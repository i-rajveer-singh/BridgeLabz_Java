/*
 * BankAccount class example
 * Demonstrates static, final, constructor
 * Instance variables and methods usage
 */

class BankAccount {

    static String bankName = "HDFC Bank";
    private static int noOfAccount = 0;

    final int accountNumber;

    String accountHolderName;
    double balance;

    // Constructor
    BankAccount(String accountHolderName, int accountNumber, double balance){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        noOfAccount++;
    }

    // Display account details
    void displayDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Bank Name       : " + bankName);
        System.out.println("Account Holder  : " + accountHolderName);
        System.out.println("Account Number  : " + accountNumber);
        System.out.println("Balance         : " + balance);
    }

    // Show total accounts
    static void getTotalAccounts(){
        System.out.println("\nTotal Accounts Created : " + noOfAccount);
    }

    // Main method
    public static void main(String[] args){
        BankAccount acc1 = new BankAccount("Aadi",12345,10000.0);

        if(acc1 instanceof BankAccount){
            acc1.displayDetails();
        }

        BankAccount acc2 = new BankAccount("Sahi",12346,10400.0);

        BankAccount.getTotalAccounts();
    }
}
