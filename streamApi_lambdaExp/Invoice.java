public class Invoice {
    private final String invoiceId;

    public Invoice(String transactionId) {
        this.invoiceId = "INV-" + transactionId;
    }

    public String toString() {
        return invoiceId;
    }
}
