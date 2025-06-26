package corejava;

public class BankAccount {
    // Step 1: Declare balance
    double balance = 0;

    // Step 2: Method to deposit money
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
    }

    // Step 3: Method to withdraw money
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    // Step 4: Method to show balance
    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Main method to test the class
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();  // Create account object

        myAccount.deposit(1000);       // Add 1000
        myAccount.withdraw(300);       // Take 300
        myAccount.showBalance();       // Show remaining balance
    }
}