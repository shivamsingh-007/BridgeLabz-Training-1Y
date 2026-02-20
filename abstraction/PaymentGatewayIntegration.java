public class PaymentGatewayIntegration {

    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeProcessor();
        PaymentProcessor paypal = new PayPalProcessor();

        stripe.processPayment(500.0);
        stripe.refund(500.0);

        paypal.processPayment(300.0);
        paypal.refund(300.0);
    }
}

interface PaymentProcessor {
    void processPayment(double amount);

    default void refund(double amount) {
        System.out.println("Processing refund of " + amount + " using default refund method");
    }
}

class StripeProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Stripe processing payment of " + amount);
    }
}

class PayPalProcessor implements PaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("PayPal processing payment of " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("PayPal custom refund of " + amount);
    }
}
