package corejava;

class BankAccount {
    private int balance = 1000; // Starting balance
    public synchronized void withdraw(int amount) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " is trying to withdraw ₹" + amount);

        if (balance >= amount) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }

            balance -= amount;
            System.out.println(threadName + " completed withdrawal. Remaining balance: ₹" + balance);
        } else {
            System.out.println(threadName + " cannot withdraw. Insufficient funds! Balance: ₹" + balance);
        }
    }

    public int getBalance() {
        return balance;
    }
}

class UserThread extends Thread {
    private BankAccount account;

    public UserThread(BankAccount account, String name) {
        super(name); 
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 2; i++) { 
            account.withdraw(600);    // Try withdrawing ₹600
        }
    }
}

public class BankingApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        UserThread user1 = new UserThread(account, "User-1");
        UserThread user2 = new UserThread(account, "User-2");
        UserThread user3 = new UserThread(account, "User-3");

        user1.start();
        user2.start();
        user3.start();
    }
}
