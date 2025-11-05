package kosukeroku.web_quiz_engine.mapper;

import kosukeroku.web_quiz_engine.dto.UserRequest;
import kosukeroku.web_quiz_engine.dto.UserResponse;
import kosukeroku.web_quiz_engine.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toResponse (User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    User toEntity (UserRequest userRequest);
}
