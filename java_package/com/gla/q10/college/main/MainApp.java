package college.main;

import static java.lang.Math.*;

import college.student.Student;
import college.faculty.Faculty;
import college.department.Department;

public class MainApp {

    public static void main(String[] args) {

        Student s1 = new Student("Arjun Reddy", 101, "Computer Science", 8.9);
        Student s2 = new Student("Meera Joshi", 102, "Electronics", 9.2);

        Faculty f1 = new Faculty("Dr. Ramesh Sharma", "Data Structures", 12);
        Faculty f2 = new Faculty("Prof. Anita Gupta", "Digital Electronics", 8);

        Department d1 = new Department("Computer Science", 120, 15);
        Department d2 = new Department("Electronics", 95, 12);

        System.out.println("============================================");
        System.out.println("        COLLEGE MANAGEMENT SYSTEM           ");
        System.out.println("============================================");

        System.out.println();
        System.out.println("====== STUDENTS ======");
        System.out.println();
        System.out.println("Student 1:");
        s1.displayStudent();
        System.out.println();
        System.out.println("Student 2:");
        s2.displayStudent();

        System.out.println();
        System.out.println("====== FACULTY ======");
        System.out.println();
        System.out.println("Faculty 1:");
        f1.displayFaculty();
        System.out.println();
        System.out.println("Faculty 2:");
        f2.displayFaculty();

        System.out.println();
        System.out.println("====== DEPARTMENTS ======");
        System.out.println();
        System.out.println("Department 1:");
        d1.displayDepartment();
        System.out.println();
        System.out.println("Department 2:");
        d2.displayDepartment();

        System.out.println();
        System.out.println("====== ANALYTICS (using static import) ======");
        System.out.println("Highest CGPA : " + max(s1.getCgpa(), s2.getCgpa()));
        System.out.println("Lowest CGPA  : " + min(s1.getCgpa(), s2.getCgpa()));
        System.out.println("sqrt(81)     : " + sqrt(81));

        System.out.println();
        System.out.println("=== How Packages Helped ===");
        System.out.println("college.student    : Manages all student data");
        System.out.println("college.faculty    : Manages all faculty data");
        System.out.println("college.department : Manages department info");
        System.out.println("college.main       : Entry point, imports and uses all packages");
        System.out.println("Packages prevent name conflicts and keep code well organized");
    }
}
