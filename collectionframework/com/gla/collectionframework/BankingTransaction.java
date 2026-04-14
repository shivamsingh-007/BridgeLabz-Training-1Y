package com.gla.collectionframework;

import java.util.*;

public class BankingTransaction {
    private List<Transaction> transactionHistory;
    private Queue<Transaction> pendingTransactions;
    private Set<String> verifiedTransactionIds;
    private Stack<Transaction> processedStack;

    public BankingTransaction() {
        this.transactionHistory = new ArrayList<>();
        this.pendingTransactions = new LinkedList<>();
        this.verifiedTransactionIds = new HashSet<>();
        this.processedStack = new Stack<>();
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
        pendingTransactions.offer(transaction);
    }

    public void processTransaction() {
        Transaction tx = pendingTransactions.poll();
        if (tx != null) {
            tx.process();
            verifiedTransactionIds.add(tx.getTransactionId());
            processedStack.push(tx);
        }
    }

    public void reverseLastTransaction() {
        if (!processedStack.isEmpty()) {
            Transaction tx = processedStack.pop();
            verifiedTransactionIds.remove(tx.getTransactionId());
            System.out.println("Reversed: " + tx.getTransactionId());
        }
    }

    public List<Transaction> getTransactionsByAccount(String accountId) {
        List<Transaction> accountTx = new ArrayList<>();
        for (Transaction tx : transactionHistory) {
            if (tx.getAccountId().equals(accountId)) {
                accountTx.add(tx);
            }
        }
        return accountTx;
    }

    public Set<String> getVerifiedTransactionIds() {
        return verifiedTransactionIds;
    }

    public int getPendingCount() {
        return pendingTransactions.size();
    }

    public static void main(String[] args) {
        BankingTransaction bank = new BankingTransaction();
        bank.addTransaction(new Transaction("T001", "A001", 500.00, "CREDIT"));
        bank.addTransaction(new Transaction("T002", "A002", 200.00, "DEBIT"));
        bank.addTransaction(new Transaction("T003", "A001", 150.00, "DEBIT"));
        System.out.println("Pending: " + bank.getPendingCount());
        bank.processTransaction();
        bank.processTransaction();
        System.out.println("Verified: " + bank.getVerifiedTransactionIds());
        bank.reverseLastTransaction();
        System.out.println("Verified after reverse: " + bank.getVerifiedTransactionIds());
    }
}

class Transaction {
    private String transactionId;
    private String accountId;
    private double amount;
    private String type;

    public Transaction(String transactionId, String accountId, double amount, String type) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    public void process() {
        System.out.println("Processing " + type + " of " + amount);
    }

    public String getTransactionId() { return transactionId; }
    public String getAccountId() { return accountId; }
    public double getAmount() { return amount; }
    public String getType() { return type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId);
    }
}
