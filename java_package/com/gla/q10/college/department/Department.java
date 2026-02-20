package college.department;

public class Department {

    private String departmentName;
    private int totalStudents;
    private int totalFaculty;

    public Department(String departmentName, int totalStudents, int totalFaculty) {
        this.departmentName = departmentName;
        this.totalStudents = totalStudents;
        this.totalFaculty = totalFaculty;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void displayDepartment() {
        System.out.println("Department     : " + departmentName);
        System.out.println("Total Students : " + totalStudents);
        System.out.println("Total Faculty  : " + totalFaculty);
    }
}
