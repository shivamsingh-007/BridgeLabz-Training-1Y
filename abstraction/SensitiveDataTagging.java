import java.util.ArrayList;
import java.util.List;

public class SensitiveDataTagging {

    public static void main(String[] args) {
        List<Object> dataObjects = new ArrayList<>();
        dataObjects.add(new CreditCardInfo("4111111111111111", "Alice"));
        dataObjects.add(new PublicAnnouncement("Company holiday on Monday"));
        dataObjects.add(new MedicalRecord("Alice", "Hypertension"));

        for (Object obj : dataObjects) {
            if (obj instanceof SensitiveData) {
                System.out.println("[SENSITIVE - ENCRYPTION REQUIRED] Processing: " + obj.getClass().getSimpleName());
            } else {
                System.out.println("[PUBLIC] Processing: " + obj.getClass().getSimpleName());
            }
        }
    }
}

interface SensitiveData {
}

class CreditCardInfo implements SensitiveData {
    private String cardNumber;
    private String holderName;

    public CreditCardInfo(String cardNumber, String holderName) {
        this.cardNumber = cardNumber;
        this.holderName = holderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}

class MedicalRecord implements SensitiveData {
    private String patientName;
    private String diagnosis;

    public MedicalRecord(String patientName, String diagnosis) {
        this.patientName = patientName;
        this.diagnosis = diagnosis;
    }
}

class PublicAnnouncement {
    private String message;

    public PublicAnnouncement(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
