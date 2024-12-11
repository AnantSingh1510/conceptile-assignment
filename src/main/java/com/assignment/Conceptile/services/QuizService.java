package com.assignment.Conceptile.services;

import com.assignment.Conceptile.models.Question;
import com.assignment.Conceptile.models.QuizSession;
import com.assignment.Conceptile.repositories.QuestionRepository;
import com.assignment.Conceptile.repositories.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    public QuizSession startNewSession() {
        QuizSession session = new QuizSession();
        quizSessionRepository.save(session);
        return session;
    }

//    public Optional<Question> getRandomQuestion(Long sessionId) {
//        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow();
//        List<Question> unanswered = questionRepository.findAllByIdNotIn(session.getAnsweredQuestions());
//        if (unanswered.isEmpty()) return Optional.empty();
//        Question randomQuestion = unanswered.get(new Random().nextInt(unanswered.size()));
//        return Optional.of(randomQuestion);
//    }

    public Question getRandomQuestion(Long sessionId) {
        QuizSession session = quizSessionRepository.findById(sessionId)
                .orElseThrow();
        List<Question> unansweredQuestions = questionRepository.findAll()
                .stream()
                .filter(q -> !session.getAnsweredQuestions().contains(q))
                .collect(Collectors.toList());
        return unansweredQuestions.get(new Random().nextInt(unansweredQuestions.size()));
    }


    public void submitAnswer(Long sessionId, Long questionId, String answer) {
        QuizSession session = quizSessionRepository.findById(sessionId).orElseThrow();
        Question question = questionRepository.findById(questionId).orElseThrow();

        session.getAnsweredQuestions().add(question.getId());
        if (question.getCorrectAnswer().equalsIgnoreCase(answer)) {
            session.incrementCorrectAnswers();
        } else {
            session.incrementIncorrectAnswers();
        }
        quizSessionRepository.save(session);
    }

    public QuizSession getSummary(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElseThrow();
    }
}
