import java.util.*;
public class Student {
    int id;
    int age;
    String name;
void display(String name, int age,int id_roll){
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("ID Roll: " + id_roll);
}
    public static void main(String[] args) {
        Student s1 =   new Student();
s1.id = 120;
s1.age = 18;
s1.name ="rahul";


        s1.display(s1.name, s1.age, s1.id);
    }
}