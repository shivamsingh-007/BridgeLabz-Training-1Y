package com.school.data;

public class Student {

    private String name;
    private double marks1;
    private double marks2;
    private double marks3;

    public Student(String name, double marks1, double marks2, double marks3) {
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    public String getName() {
        return name;
    }

    public double getMarks1() {
        return marks1;
    }

    public double getMarks2() {
        return marks2;
    }

    public double getMarks3() {
        return marks3;
    }

    public String toString() {
        return "Student   : " + name + "\n" +
               "Subject 1 : " + marks1 + "\n" +
               "Subject 2 : " + marks2 + "\n" +
               "Subject 3 : " + marks3;
    }
}
