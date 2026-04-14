package com.gla.collectionframework;

import java.util.*;

public class OnlineExamination {
    private List<Question> questionBank;
    private Set<String> attemptedQuestions;
    private Queue<Student> waitingStudents;
    private Stack<ExamSession> examSessions;

    public OnlineExamination() {
        this.questionBank = new ArrayList<>();
        this.attemptedQuestions = new HashSet<>();
        this.waitingStudents = new LinkedList<>();
        this.examSessions = new Stack<>();
    }

    public void addQuestion(Question question) {
        questionBank.add(question);
    }

    public void registerStudent(Student student) {
        waitingStudents.offer(student);
    }

    public Student startExam() {
        Student student = waitingStudents.poll();
        if (student != null) {
            examSessions.push(new ExamSession(student, new ArrayList<>()));
        }
        return student;
    }

    public void submitAnswer(String questionId) {
        attemptedQuestions.add(questionId);
        if (!examSessions.isEmpty()) {
            examSessions.peek().answeredQuestions.add(questionId);
        }
    }

    public void endExam() {
        if (!examSessions.isEmpty()) {
            examSessions.pop();
        }
    }

    public List<Question> getQuestionsByTopic(String topic) {
        List<Question> topicQuestions = new ArrayList<>();
        for (Question q : questionBank) {
            if (q.getTopic().equals(topic)) {
                topicQuestions.add(q);
            }
        }
        return topicQuestions;
    }

    public Set<String> getAttemptedQuestions() {
        return attemptedQuestions;
    }

    public int getWaitingCount() {
        return waitingStudents.size();
    }

    public static void main(String[] args) {
        OnlineExamination exam = new OnlineExamination();
        exam.addQuestion(new Question("Q1", "Java", "What is polymorphism?"));
        exam.addQuestion(new Question("Q2", "Python", "What is a decorator?"));
        exam.addQuestion(new Question("Q3", "Java", "What is inheritance?"));
        exam.registerStudent(new Student("S001", "John"));
        exam.registerStudent(new Student("S002", "Jane"));
        System.out.println("Waiting students: " + exam.getWaitingCount());
        Student current = exam.startExam();
        if (current != null) System.out.println("Exam started for: " + current.getName());
        exam.submitAnswer("Q1");
        System.out.println("Attempted: " + exam.getAttemptedQuestions());
    }
}

class Question {
    private String questionId;
    private String topic;
    private String content;

    public Question(String questionId, String topic, String content) {
        this.questionId = questionId;
        this.topic = topic;
        this.content = content;
    }

    public String getQuestionId() { return questionId; }
    public String getTopic() { return topic; }
    public String getContent() { return content; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(questionId, question.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId);
    }
}

class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }

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
}

class ExamSession {
    Student student;
    List<String> answeredQuestions;

    public ExamSession(Student student, List<String> answeredQuestions) {
        this.student = student;
        this.answeredQuestions = answeredQuestions;
    }
}
