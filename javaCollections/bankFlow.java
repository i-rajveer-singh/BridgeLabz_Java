package collections;
/*
 * BankFlowManager handles customer accounts using HashMap for fast access,
 * TreeMap for sorting customers by balance, and Queue to process
 * withdrawal requests sequentially.
 */

import java.util.*;

// Represents a withdrawal request
class WithdrawalRequest {
    String accountNumber;
    double amount;

    public WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankFlowManager {

    private Map<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> sortedByBalance = new TreeMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Adds a new account
    public void addAccount(String accNumber, double balance) {
        accounts.put(accNumber, balance);

        sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>())
                .add(accNumber); // Track sorted balances
    }

    // Adds withdrawal request to queue
    public void requestWithdrawal(String accNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accNumber, amount));
    }

    // Processes withdrawals in FIFO order
    public void processWithdrawals() {

        while (!withdrawalQueue.isEmpty()) {

            WithdrawalRequest req = withdrawalQueue.remove();
            double balance = accounts.getOrDefault(req.accountNumber, 0.0);

            if (balance >= req.amount) {

                updateSortedMap(req.accountNumber, balance, balance - req.amount);
                accounts.put(req.accountNumber, balance - req.amount);

                System.out.println("Withdrawal successful for " + req.accountNumber);
            } else {
                System.out.println("Insufficient funds for " + req.accountNumber);
            }
        }
    }

    // Updates TreeMap after balance change
    private void updateSortedMap(String acc, double oldBal, double newBal) {

        List<String> oldList = sortedByBalance.get(oldBal);
        oldList.remove(acc);

        if (oldList.isEmpty())
            sortedByBalance.remove(oldBal);

        sortedByBalance.computeIfAbsent(newBal, k -> new ArrayList<>())
                .add(acc);
    }

    // Displays accounts sorted by balance
    public void displaySortedAccounts() {

        sortedByBalance.forEach((balance, accs) ->
                accs.forEach(acc -> System.out.println(acc + " -> $" + balance)));
    }

    // Entry point
    public static void main(String[] args) {

        BankFlowManager bank = new BankFlowManager();

        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 12000);
        bank.addAccount("A103", 3000);

        bank.requestWithdrawal("A101", 2000);
        bank.requestWithdrawal("A103", 4000);

        bank.processWithdrawals();

        System.out.println("\nAccounts Sorted by Balance:");
        bank.displaySortedAccounts();
    }
}
