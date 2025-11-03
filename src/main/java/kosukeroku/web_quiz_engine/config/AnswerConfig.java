package kosukeroku.web_quiz_engine.config;

import kosukeroku.web_quiz_engine.dto.AnswerResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnswerConfig {


    @Bean
    public AnswerResponse rightAnswer() {
        return new AnswerResponse(true, "Congratulations, you're right!");
    }

    @Bean
    public AnswerResponse wrongAnswer() {
        return new AnswerResponse(false, "Wrong answer! Please, try again.");
    }
}
