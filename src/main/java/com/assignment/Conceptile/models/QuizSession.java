package com.assignment.Conceptile.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class QuizSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<Long> answeredQuestions = new ArrayList<>();

    private int correctAnswers;
    private int incorrectAnswers;

    public void incrementCorrectAnswers() {
        this.correctAnswers++;
    }

    public void incrementIncorrectAnswers() {
        this.incorrectAnswers++;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getAnsweredQuestions() {
        return answeredQuestions;
    }

    public void setAnsweredQuestions(List<Long> answeredQuestions) {
        this.answeredQuestions = answeredQuestions;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }
}
