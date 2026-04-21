import java.util.Arrays;
import java.util.List;

public class StockPriceLogger {

    public static void main(String[] args) {
        List<StockPrice> stockPrices = Arrays.asList(
                new StockPrice("INFY", 1512.30),
                new StockPrice("TCS", 3980.50),
                new StockPrice("WIPRO", 520.15)
        );

        stockPrices.forEach(System.out::println);
    }
}
