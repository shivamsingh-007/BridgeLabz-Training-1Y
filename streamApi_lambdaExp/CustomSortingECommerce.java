import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomSortingECommerce {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 82000, 4.7, 10),
                new Product("Headphones", 4500, 4.3, 25),
                new Product("Smart Watch", 15999, 4.8, 15),
                new Product("Camera", 51000, 4.5, 12)
        );

        System.out.println("Sorted by price");
        products.stream().sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())).forEach(System.out::println);
        System.out.println("Sorted by rating");
        products.stream().sorted((p1, p2) -> Double.compare(p2.getRating(), p1.getRating())).forEach(System.out::println);
        System.out.println("Sorted by discount");
        products.stream().sorted((p1, p2) -> Double.compare(p2.getDiscount(), p1.getDiscount())).forEach(System.out::println);
    }
}
