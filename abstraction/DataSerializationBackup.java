import java.util.ArrayList;
import java.util.List;

public class DataSerializationBackup {

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(new UserProfile("Alice", 30));
        objects.add(new SystemConfig("DEBUG", true));
        objects.add(new TempData("temp"));

        for (Object obj : objects) {
            if (obj instanceof Backupable) {
                System.out.println("Backing up: " + obj.getClass().getSimpleName());
            } else {
                System.out.println("Skipping backup for: " + obj.getClass().getSimpleName());
            }
        }
    }
}

interface Backupable {
}

class UserProfile implements Backupable {
    private String username;
    private int age;

    public UserProfile(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }
}

class SystemConfig implements Backupable {
    private String logLevel;
    private boolean debugMode;

    public SystemConfig(String logLevel, boolean debugMode) {
        this.logLevel = logLevel;
        this.debugMode = debugMode;
    }
}

class TempData {
    private String data;

    public TempData(String data) {
        this.data = data;
    }
}
