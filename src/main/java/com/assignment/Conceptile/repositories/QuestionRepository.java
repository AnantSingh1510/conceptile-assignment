package com.assignment.Conceptile.repositories;

import com.assignment.Conceptile.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByIdNotIn(List<Long> ids);
}
