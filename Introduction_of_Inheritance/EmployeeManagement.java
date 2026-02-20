public class EmployeeManagement {

    public static void main(String[] args) {
        Employee manager = new Manager("Alice", 101, 90000, 10);
        Employee developer = new Developer("Bob", 102, 75000, "Java");
        Employee intern = new Intern("Charlie", 103, 20000, "Computer Science");

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: " + salary);
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("Manager - Name: " + getName() + ", ID: " + getId() + ", Salary: " + getSalary() + ", Team Size: " + teamSize);
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        System.out.println("Developer - Name: " + getName() + ", ID: " + getId() + ", Salary: " + getSalary() + ", Language: " + programmingLanguage);
    }
}

class Intern extends Employee {
    private String department;

    public Intern(String name, int id, double salary, String department) {
        super(name, id, salary);
        this.department = department;
    }

    @Override
    public void displayDetails() {
        System.out.println("Intern - Name: " + getName() + ", ID: " + getId() + ", Salary: " + getSalary() + ", Department: " + department);
    }
}
