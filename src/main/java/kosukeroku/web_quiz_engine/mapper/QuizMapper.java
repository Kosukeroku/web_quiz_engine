package kosukeroku.web_quiz_engine.mapper;

import kosukeroku.web_quiz_engine.dto.QuizRequest;
import kosukeroku.web_quiz_engine.dto.QuizResponse;
import kosukeroku.web_quiz_engine.model.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuizMapper {

    QuizResponse toResponse(Quiz quiz);


    @Mapping(target = "id", ignore = true)
    Quiz toEntity(QuizRequest quizRequest);
}