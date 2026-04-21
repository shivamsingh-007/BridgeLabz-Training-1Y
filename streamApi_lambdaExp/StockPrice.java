public class StockPrice {
    private final String symbol;
    private final double price;

    public StockPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String toString() {
        return symbol + " -> " + price;
    }
}
