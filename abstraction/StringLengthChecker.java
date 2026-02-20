import java.util.function.Function;

public class StringLengthChecker {

    public static void main(String[] args) {
        int characterLimit = 50;
        Function<String, Integer> getLength = String::length;

        String[] messages = {
            "Hello",
            "This is a short message",
            "This is a very long message that might exceed the character limit set for the system"
        };

        for (String message : messages) {
            int length = getLength.apply(message);
            if (length > characterLimit) {
                System.out.println("Message exceeds limit! Length: " + length + " | Message: " + message);
            } else {
                System.out.println("Message OK. Length: " + length + " | Message: " + message);
            }
        }
    }
}
