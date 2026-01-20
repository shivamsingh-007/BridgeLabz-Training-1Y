import java.util.Scanner;
public class Student {
static void display(String name, int age,int id_roll){
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("ID Roll: " + id_roll);
}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter student id roll:");
        int id_roll = input.nextInt();
        System.out.println("Enter student age:");
        int age = input.nextInt();
        System.out.println("Enter student name:");
        String name = input.next();



        display(name, age, id_roll);
    }
}