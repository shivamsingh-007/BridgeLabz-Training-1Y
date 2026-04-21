import java.util.Arrays;
import java.util.List;

public class TransformingNamesForDisplay {

    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList("zara", "amit", "neha", "karan");
        customerNames.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
    }
}
