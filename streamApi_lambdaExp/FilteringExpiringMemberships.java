import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FilteringExpiringMemberships {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        List<Member> members = Arrays.asList(
                new Member("Asha", today.plusDays(10)),
                new Member("Bharat", today.plusDays(35)),
                new Member("Charu", today.plusDays(2)),
                new Member("Deepak", today.minusDays(1))
        );

        members.stream()
                .filter(member -> !member.getExpiryDate().isBefore(today) && !member.getExpiryDate().isAfter(today.plusDays(30)))
                .forEach(System.out::println);
    }
}
