package com.assignment.Conceptile.controllers;

import com.assignment.Conceptile.models.Question;
import com.assignment.Conceptile.models.QuizSession;
import com.assignment.Conceptile.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz() {
        return quizService.startNewSession();
    }

    @GetMapping("/question")
    public Question getQuestion(@RequestParam Long sessionId) {
        return quizService.getRandomQuestion(sessionId);
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long sessionId, @RequestParam Long questionId, @RequestParam String answer) {
        quizService.submitAnswer(sessionId, questionId, answer);
        return "Answer submitted successfully";
    }

    @GetMapping("/summary")
    public QuizSession getSummary(@RequestParam Long sessionId) {
        return quizService.getSummary(sessionId);
    }
}