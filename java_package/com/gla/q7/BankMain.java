import static java.lang.Math.*;
import com.bank.util.InterestCalculator;

public class BankMain {

    public static void main(String[] args) {

        InterestCalculator calc = new InterestCalculator();

        double principal = 10000;
        double rate = 8;
        double time = 3;

        System.out.println("===== Banking Interest Calculator =====");
        System.out.println("Principal : Rs. " + principal);
        System.out.println("Rate      : " + rate + "%");
        System.out.println("Time      : " + time + " years");
        System.out.println();

        double si = calc.calculateSimpleInterest(principal, rate, time);
        System.out.println("Simple Interest        : Rs. " + si);
        System.out.println("Total Amount (SI)      : Rs. " + (principal + si));
        System.out.println();

        double ci = calc.calculateCompoundInterest(principal, rate, time);
        System.out.println("Compound Interest      : Rs. " + ci);
        System.out.println("Total Amount (CI)      : Rs. " + (principal + ci));
        System.out.println();

        double manualCI = principal * pow((1 + rate / 100), time) - principal;
        System.out.println("Manual CI (static import pow): Rs. " + manualCI);
    }
}
