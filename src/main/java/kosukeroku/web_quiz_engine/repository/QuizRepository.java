package kosukeroku.web_quiz_engine.repository;

import kosukeroku.web_quiz_engine.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
