package com.assignment.Conceptile.config;

import com.assignment.Conceptile.models.Question;
import com.assignment.Conceptile.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void run(String... args) throws Exception {
        if (questionRepository.count() == 0) {
            List<Question> questions = List.of(
                    new Question("What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome", "A"),
                    new Question("Who wrote 'Hamlet'?", "Shakespeare", "Hemingway", "Faulkner", "Joyce", "A"),
                    new Question("What is the boiling point of water?", "90°C", "100°C", "80°C", "110°C", "B"),
                    new Question("What is the largest planet in our Solar System?", "Earth", "Mars", "Jupiter", "Saturn", "C"),
                    new Question("What is the square root of 16?", "2", "4", "8", "16", "B"),
                    new Question("Who painted the Mona Lisa?", "Van Gogh", "Picasso", "Da Vinci", "Rembrandt", "C"),
                    new Question("What is the chemical symbol for water?", "H2", "O2", "H2O", "HO2", "C"),
                    new Question("Which year did World War II end?", "1941", "1945", "1939", "1950", "B"),
                    new Question("What is the capital of Japan?", "Seoul", "Tokyo", "Beijing", "Shanghai", "B"),
                    new Question("Which continent is known as the 'Dark Continent'?", "Asia", "South America", "Africa", "Europe", "C")
            );
            questionRepository.saveAll(questions);
        }
    }
}
