public class DigitalPayment {

    public static void main(String[] args) {
        PaymentMethod upi = new UPIPayment();
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod wallet = new WalletPayment();

        upi.pay(500.0);
        card.pay(1200.0);
        wallet.pay(300.0);
    }
}

interface PaymentMethod {
    void pay(double amount);
}

class UPIPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using UPI");
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class WalletPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Wallet");
    }
}
