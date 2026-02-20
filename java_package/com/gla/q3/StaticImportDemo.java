import static java.lang.Math.*;

public class StaticImportDemo {

    public static void main(String[] args) {

        double number = 144.0;
        double base = 2.0;
        double exponent = 10.0;
        int a = 45;
        int b = 78;
        int negativeNumber = -99;

        System.out.println("=== Static Import Demo using Math class ===");
        System.out.println();

        System.out.println("sqrt(" + number + ")     = " + sqrt(number));
        System.out.println("pow(" + base + ", " + exponent + ")   = " + pow(base, exponent));
        System.out.println("max(" + a + ", " + b + ")     = " + max(a, b));
        System.out.println("min(" + a + ", " + b + ")     = " + min(a, b));
        System.out.println("abs(" + negativeNumber + ")        = " + abs(negativeNumber));
        System.out.println("ceil(4.3)       = " + ceil(4.3));
        System.out.println("floor(4.9)      = " + floor(4.9));

        System.out.println();
        System.out.println("=== When to Use Static Import ===");
        System.out.println("USE   : When a method is used very frequently e.g. Math.sqrt");
        System.out.println("AVOID : When two classes have same method name, causes confusion");
        System.out.println("AVOID : Overusing it makes code hard to read and maintain");
    }
}
