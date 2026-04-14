package com.gla.generics;

public class AssignmentCourse implements CourseType {
    private int numAssignments;
    private int durationWeeks;

    public AssignmentCourse(int numAssignments, int durationWeeks) {
        this.numAssignments = numAssignments;
        this.durationWeeks = durationWeeks;
    }

    public int getNumAssignments() {
        return numAssignments;
    }

    public String getCourseType() {
        return "Assignment-based (" + numAssignments + " assignments)";
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }
}
