import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q14FindRepeatingWords {
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Pattern pattern = Pattern.compile("(?i)\\b(\\w+)\\s+\\1\\b");
        Matcher matcher = pattern.matcher(text);
        Set<String> repeatedWords = new LinkedHashSet<>();

        while (matcher.find()) {
            repeatedWords.add(matcher.group(1));
        }

        for (String word : repeatedWords) {
            System.out.println(word);
        }
    }
}