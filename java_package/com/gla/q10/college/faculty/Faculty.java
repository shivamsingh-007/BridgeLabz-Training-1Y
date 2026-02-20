package college.faculty;

public class Faculty {

    private String name;
    private String subject;
    private int experienceYears;

    public Faculty(String name, String subject, int experienceYears) {
        this.name = name;
        this.subject = subject;
        this.experienceYears = experienceYears;
    }

    public String getName() {
        return name;
    }

    public void displayFaculty() {
        System.out.println("Name       : " + name);
        System.out.println("Subject    : " + subject);
        System.out.println("Experience : " + experienceYears + " years");
    }
}
