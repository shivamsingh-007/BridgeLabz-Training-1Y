import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InsuranceClaimAnalysis {

    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("medical", 12000),
                new Claim("dental", 4500),
                new Claim("medical", 18000),
                new Claim("vision", 2500),
                new Claim("dental", 3900)
        );

        Map<String, Double> averageByType = claims.stream()
                .collect(Collectors.groupingBy(Claim::getType, Collectors.averagingDouble(Claim::getAmount)));

        averageByType.forEach((type, average) -> System.out.println(type + " -> " + average));
    }
}
