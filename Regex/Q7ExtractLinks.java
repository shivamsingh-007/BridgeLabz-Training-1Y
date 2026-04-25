import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q7ExtractLinks {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        Pattern pattern = Pattern.compile("\\bhttps?://[\\w.-]+(?:\\.[\\w.-]+)+(?:/\\S*)?\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}