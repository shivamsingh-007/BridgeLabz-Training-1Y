import college.student.Student;
import college.faculty.Faculty;

public class Main {

    public static void main(String[] args) {

        Student s = new Student("Ravi Kumar", 101);
        Faculty f = new Faculty("Dr. Mehta", "Data Structures");

        s.displayDetails();
        System.out.println();
        f.displayDetails();
    }
}
