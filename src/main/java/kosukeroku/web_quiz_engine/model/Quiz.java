package kosukeroku.web_quiz_engine.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "quizzes")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String title;
    private String text;

    @ElementCollection
    @CollectionTable(name = "quiz_options", joinColumns = @JoinColumn(name = "quiz_id"))
    @Column(name = "option_value")
    private List<String> options;
}
