import java.util.LinkedHashMap;
import java.util.Map;

public class SmartHomeLightingAutomation {

    public static void main(String[] args) {
        Map<String, Runnable> actions = new LinkedHashMap<String, Runnable>();
        actions.put("motion", () -> System.out.println("Motion detected: lights brighten to 80%"));
        actions.put("evening", () -> System.out.println("Evening mode: warm lights turn on"));
        actions.put("voice", () -> System.out.println("Voice command: bedroom lights switch to reading mode"));
        actions.values().forEach(Runnable::run);
    }
}
