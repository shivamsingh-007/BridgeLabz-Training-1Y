package com.school.main;

import com.school.data.*;
import com.school.util.*;

public class MainApp {

    public static void main(String[] args) {

        Student s1 = new Student("Karan Mehta", 88, 92, 76);
        Student s2 = new Student("Divya Nair", 55, 63, 49);

        Analyzer analyzer = new Analyzer();

        System.out.println("===== Student Performance Analyzer =====");
        System.out.println();

        System.out.println(s1.toString());
        double avg1 = analyzer.calculateAverage(s1);
        System.out.println("Average   : " + avg1);
        System.out.println("Grade     : " + analyzer.findGrade(avg1));
        System.out.println();

        System.out.println(s2.toString());
        double avg2 = analyzer.calculateAverage(s2);
        System.out.println("Average   : " + avg2);
        System.out.println("Grade     : " + analyzer.findGrade(avg2));
    }
}
