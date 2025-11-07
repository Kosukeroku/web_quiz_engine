package kosukeroku.web_quiz_engine.repository;

import kosukeroku.web_quiz_engine.model.Quiz;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @NonNull
    Page<Quiz> findAll(Pageable pageable);
}
