package com.gla.generics;

public class ExamCourse implements CourseType {
    private String examName;
    private int durationWeeks;

    public ExamCourse(String examName, int durationWeeks) {
        this.examName = examName;
        this.durationWeeks = durationWeeks;
    }

    public String getExamName() {
        return examName;
    }

    public String getCourseType() {
        return "Exam: " + examName;
    }

    public int getDurationWeeks() {
        return durationWeeks;
    }
}
