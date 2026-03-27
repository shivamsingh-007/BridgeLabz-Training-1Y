class BankAccount implements Runnable {
    String accountHolder;
    String accountType;

    BankAccount(String accountHolder, String accountType) {
        this.accountHolder = accountHolder;
        this.accountType = accountType;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("User: " + accountHolder + " | Account Type: " + accountType +
                    " | Priority: " + Thread.currentThread().getPriority() +
                    " | Checking balance... (Check " + i + ")");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(accountHolder + " was interrupted.");
            }
            System.out.println("User: " + accountHolder + " | Balance check " + i + " complete.");
        }
    }
}

public class BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount premium = new BankAccount("Alice", "Premium");
        BankAccount regular = new BankAccount("Bob", "Regular");
        BankAccount basic = new BankAccount("Charlie", "Basic");

        Thread t1 = new Thread(premium);
        Thread t2 = new Thread(regular);
        Thread t3 = new Thread(basic);

        t1.setPriority(10);
        t2.setPriority(5);
        t3.setPriority(1);

        t1.setName("PremiumThread");
        t2.setName("RegularThread");
        t3.setName("BasicThread");

        t1.start();
        t2.start();
        t3.start();
    }
}
