import java.time.LocalDate;

public class Member {
    private final String name;
    private final LocalDate expiryDate;

    public Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String toString() {
        return name + " | expiry=" + expiryDate;
    }
}
