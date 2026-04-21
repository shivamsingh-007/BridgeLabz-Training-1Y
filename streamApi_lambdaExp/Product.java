public class Product {
    private final String name;
    private final double price;
    private final double rating;
    private final double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public double getDiscount() {
        return discount;
    }

    public String toString() {
        return name + " | price=" + price + " | rating=" + rating + " | discount=" + discount;
    }
}
