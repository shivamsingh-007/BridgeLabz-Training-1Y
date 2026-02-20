import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatUtility {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2024, 6, 15);

        System.out.println(DateFormatter.formatStandard(date));
        System.out.println(DateFormatter.formatShort(date));
        System.out.println(DateFormatter.formatFull(date));
        System.out.println(DateFormatter.formatInvoice(date));
    }
}

interface DateFormatter {
    static String formatStandard(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    static String formatShort(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MM-dd-yy"));
    }

    static String formatFull(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
    }

    static String formatInvoice(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }
}
