package com.bank.util;

import static java.lang.Math.*;

public class InterestCalculator {

    public double calculateSimpleInterest(double principal, double rate, double time) {
        double si = (principal * rate * time) / 100;
        return si;
    }

    public double calculateCompoundInterest(double principal, double rate, double time) {
        double ci = principal * pow((1 + rate / 100), time) - principal;
        return ci;
    }
}
