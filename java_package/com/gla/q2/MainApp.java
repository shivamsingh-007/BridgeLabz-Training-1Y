import com.university.department.cse.Course;

public class MainApp {

    public static void main(String[] args) {

        Course c1 = new Course("Data Structures", 301, 4);
        Course c2 = new Course("Operating Systems", 302, 3);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();

        System.out.println();
        System.out.println("=== Folder Structure ===");
        System.out.println("q2/");
        System.out.println("  MainApp.java");
        System.out.println("  com/university/department/cse/Course.java");
        System.out.println();
        System.out.println("Compile: javac com/university/department/cse/Course.java");
        System.out.println("         javac MainApp.java");
        System.out.println("Run    : java MainApp");
    }
}
