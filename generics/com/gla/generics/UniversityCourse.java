package com.gla.generics;

public class UniversityCourse {
    public static void main(String[] args) {
        Course<ExamCourse> mathCourse = new Course<>("Advanced Mathematics", "Dr. Smith", 
            new ExamCourse("Final Exam", 16));
        System.out.println(mathCourse);

        Course<ExamCourse> physicsCourse = new Course<>("Physics 101", "Dr. Johnson", 
            new ExamCourse("Midterm + Final", 12));
        System.out.println(physicsCourse);

        Course<AssignmentCourse> programmingCourse = new Course<>("Data Structures", "Prof. Davis", 
            new AssignmentCourse(8, 15));
        System.out.println(programmingCourse);

        Course<AssignmentCourse> designCourse = new Course<>("UI/UX Design", "Prof. Wilson", 
            new AssignmentCourse(5, 10));
        System.out.println(designCourse);
    }
}
