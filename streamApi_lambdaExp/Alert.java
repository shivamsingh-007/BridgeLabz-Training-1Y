public class Alert {
    private final String code;
    private final String type;
    private final String message;

    public Alert(String code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return code + " | " + type + " | " + message;
    }
}
