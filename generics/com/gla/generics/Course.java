package com.gla.generics;

public class Course<T extends CourseType> {
    private String courseName;
    private String instructor;
    private T courseType;

    public Course(String courseName, String instructor, T courseType) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " by " + instructor + " - " + courseType.getCourseType() + 
               " (" + courseType.getDurationWeeks() + " weeks)";
    }
}
