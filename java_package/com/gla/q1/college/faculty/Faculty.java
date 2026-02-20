package college.faculty;

public class Faculty {

    private String name;
    private String subject;

    public Faculty(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public void displayName() {
        System.out.println("Faculty Name : " + name);
    }

    public void displaySubject() {
        System.out.println("Subject      : " + subject);
    }

    public void displayDetails() {
        System.out.println("--- Faculty Details ---");
        displayName();
        displaySubject();
    }
}
