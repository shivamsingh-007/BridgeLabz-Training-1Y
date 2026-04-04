package com.gla.wrapperclass;

public class BankTransactionLimits {

    public static double getRemainingLimit(Double limit, double amountWithdrawn) {
        if (limit == null) {
            return 0.0;
        }
        double remaining = limit - amountWithdrawn;
        return remaining;
    }

    public static void main(String[] args) {
        Double account1Limit = 10000.0;
        double account1Withdrawn = 3500.0;

        Double account2Limit = null;
        double account2Withdrawn = 1000.0;

        Double account3Limit = 5000.0;
        double account3Withdrawn = 5000.0;

        System.out.println("Account 1 Remaining Limit: " + getRemainingLimit(account1Limit, account1Withdrawn));
        System.out.println("Account 2 Remaining Limit: " + getRemainingLimit(account2Limit, account2Withdrawn));
        System.out.println("Account 3 Remaining Limit: " + getRemainingLimit(account3Limit, account3Withdrawn));
    }
}
