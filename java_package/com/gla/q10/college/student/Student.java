package college.student;

public class Student {

    private String name;
    private int rollNumber;
    private String branch;
    private double cgpa;

    public Student(String name, int rollNumber, String branch, double cgpa) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void displayStudent() {
        System.out.println("Name        : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Branch      : " + branch);
        System.out.println("CGPA        : " + cgpa);
    }
}
