import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceObjectCreation {

    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN-501", "TXN-502", "TXN-503");
        List<Invoice> invoices = transactionIds.stream().map(Invoice::new).collect(Collectors.toList());
        invoices.forEach(System.out::println);
    }
}
