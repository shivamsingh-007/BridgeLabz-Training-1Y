package com.gla.collectionframework;

import java.util.*;

public class CustomerFeedback {
    private List<Feedback> allFeedback;
    private Set<String> analyzedFeedbackIds;
    private Queue<Feedback> pendingAnalysis;
    private Stack<Feedback> processedFeedback;

    public CustomerFeedback() {
        this.allFeedback = new ArrayList<>();
        this.analyzedFeedbackIds = new HashSet<>();
        this.pendingAnalysis = new LinkedList<>();
        this.processedFeedback = new Stack<>();
    }

    public void submitFeedback(Feedback feedback) {
        allFeedback.add(feedback);
        pendingAnalysis.offer(feedback);
    }

    public void analyzeFeedback() {
        Feedback feedback = pendingAnalysis.poll();
        if (feedback != null) {
            feedback.analyze();
            analyzedFeedbackIds.add(feedback.getFeedbackId());
            processedFeedback.push(feedback);
        }
    }

    public void undoAnalysis() {
        if (!processedFeedback.isEmpty()) {
            Feedback feedback = processedFeedback.pop();
            analyzedFeedbackIds.remove(feedback.getFeedbackId());
            pendingAnalysis.offer(feedback);
            System.out.println("Undo analysis: " + feedback.getFeedbackId());
        }
    }

    public List<Feedback> getFeedbackByRating(int minRating) {
        List<Feedback> ratedFeedback = new ArrayList<>();
        for (Feedback f : allFeedback) {
            if (f.getRating() >= minRating) {
                ratedFeedback.add(f);
            }
        }
        return ratedFeedback;
    }

    public Set<String> getAnalyzedFeedbackIds() {
        return analyzedFeedbackIds;
    }

    public int getPendingCount() {
        return pendingAnalysis.size();
    }

    public static void main(String[] args) {
        CustomerFeedback feedbackSystem = new CustomerFeedback();
        feedbackSystem.submitFeedback(new Feedback("F001", "Great service", 5));
        feedbackSystem.submitFeedback(new Feedback("F002", "Could be better", 3));
        feedbackSystem.submitFeedback(new Feedback("F003", "Excellent!", 5));
        System.out.println("Pending: " + feedbackSystem.getPendingCount());
        feedbackSystem.analyzeFeedback();
        feedbackSystem.analyzeFeedback();
        System.out.println("Analyzed: " + feedbackSystem.getAnalyzedFeedbackIds());
        System.out.println("High rated: " + feedbackSystem.getFeedbackByRating(4));
    }
}

class Feedback {
    private String feedbackId;
    private String comment;
    private int rating;

    public Feedback(String feedbackId, String comment, int rating) {
        this.feedbackId = feedbackId;
        this.comment = comment;
        this.rating = rating;
    }

    public void analyze() {
        System.out.println("Analyzing feedback: " + feedbackId + " - Rating: " + rating);
    }

    public String getFeedbackId() { return feedbackId; }
    public String getComment() { return comment; }
    public int getRating() { return rating; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(feedbackId, feedback.feedbackId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackId);
    }
}
