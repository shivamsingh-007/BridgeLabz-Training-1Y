package com.gla.collectionframework;

import java.util.*;

public class CollegeAdmission {
    private List<Student> applicants;
    private Set<String> admittedStudentIds;
    private Queue<Student> waitingList;
    private TreeSet<Student> rankedApplicants;

    public CollegeAdmission() {
        this.applicants = new ArrayList<>();
        this.admittedStudentIds = new HashSet<>();
        this.waitingList = new LinkedList<>();
        this.rankedApplicants = new TreeSet<>(Comparator.comparingInt(Student::getScore).reversed());
    }

    public void addApplicant(Student student) {
        applicants.add(student);
        rankedApplicants.add(student);
    }

    public void admitStudent() {
        Student student = rankedApplicants.pollFirst();
        if (student != null) {
            admittedStudentIds.add(student.getStudentId());
            System.out.println("Admitted: " + student.getName());
        }
    }

    public void addToWaitingList(Student student) {
        waitingList.offer(student);
    }

    public Student admitFromWaitingList() {
        Student student = waitingList.poll();
        if (student != null) {
            admittedStudentIds.add(student.getStudentId());
        }
        return student;
    }

    public List<Student> getApplicantsByDepartment(String department) {
        List<Student> deptApplicants = new ArrayList<>();
        for (Student s : applicants) {
            if (s.getDepartment().equals(department)) {
                deptApplicants.add(s);
            }
        }
        return deptApplicants;
    }

    public Set<String> getAdmittedStudentIds() {
        return admittedStudentIds;
    }

    public int getWaitingListSize() {
        return waitingList.size();
    }

    public static void main(String[] args) {
        CollegeAdmission admission = new CollegeAdmission();
        admission.addApplicant(new Student("ST001", "Alice", 85, "CS"));
        admission.addApplicant(new Student("ST002", "Bob", 92, "CS"));
        admission.addApplicant(new Student("ST003", "Charlie", 78, "EE"));
        admission.addApplicant(new Student("ST004", "Diana", 95, "CS"));
        System.out.println("Total applicants: " + admission.applicants.size());
        admission.admitStudent();
        admission.admitStudent();
        System.out.println("Admitted: " + admission.getAdmittedStudentIds());
        System.out.println("CS applicants: " + admission.getApplicantsByDepartment("CS"));
    }
}

class Student {
    private String studentId;
    private String name;
    private int score;
    private String department;

    public Student(String studentId, String name, int score, String department) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
        this.department = department;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getScore() { return score; }
    public String getDepartment() { return department; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}
