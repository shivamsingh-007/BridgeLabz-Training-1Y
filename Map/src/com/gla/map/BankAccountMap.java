package com.gla.map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, BankAccount> accounts = new HashMap<>();
        
        accounts.put("ACC001", new BankAccount("ACC001", "Alice", 5000.00));
        accounts.put("ACC002", new BankAccount("ACC002", "Bob", 3500.00));
        accounts.put("ACC003", new BankAccount("ACC003", "Charlie", 8000.00));
        accounts.put("ACC004", new BankAccount("ACC004", "Diana", 2500.00));
        
        System.out.println("Bank Accounts:");
        for (Map.Entry<String, BankAccount> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        
        accounts.get("ACC001").deposit(1500.00);
        System.out.println("\nAfter depositing $1500 to ACC001: $" + accounts.get("ACC001").getBalance());
        
        accounts.get("ACC002").withdraw(500.00);
        System.out.println("After withdrawing $500 from ACC002: $" + accounts.get("ACC002").getBalance());
        
        System.out.println("\nAccounts with balance > 4000:");
        accounts.forEach((accNum, account) -> {
            if (account.getBalance() > 4000) {
                System.out.println(accNum + ": " + account);
            }
        });
        
        double totalBalance = accounts.values().stream().mapToDouble(BankAccount::getBalance).sum();
        System.out.println("\nTotal Balance in Bank: $" + totalBalance);
        
        accounts.put("ACC005", new BankAccount("ACC005", "Eve", 10000.00));
        System.out.println("\nTotal Accounts: " + accounts.size());
    }
}

class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    
    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) balance -= amount;
    }
    
    @Override
    public String toString() {
        return holderName + " | Balance: $" + balance;
    }
}
