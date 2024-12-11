package com.assignment.Conceptile.repositories;

import com.assignment.Conceptile.models.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {}
