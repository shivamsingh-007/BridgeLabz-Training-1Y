import college.student.Student;

public class MainApp {

    public static void main(String[] args) {

        Student s = new Student("Anjali Sharma", 201, "Computer Science");
        s.displayDetails();

        System.out.println();
        System.out.println("=== Compile and Run Commands ===");
        System.out.println();
        System.out.println("Step 1: javac -d out/collegeinfo collegeinfo/module-info.java collegeinfo/college/student/Student.java");
        System.out.println("Step 2: javac --module-path out -d out/app app/module-info.java app/MainApp.java");
        System.out.println("Step 3: java --module-path out -m app/MainApp");
        System.out.println();
        System.out.println("=== Packages vs Modules ===");
        System.out.println("Package : Groups related classes inside a project");
        System.out.println("Module  : Groups related packages with explicit dependencies");
        System.out.println("Package : No strict access control between packages");
        System.out.println("Module  : Uses exports and requires for strict access control");
    }
}
