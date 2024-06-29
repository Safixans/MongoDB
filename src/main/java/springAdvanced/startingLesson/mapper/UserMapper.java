package springAdvanced.startingLesson.mapper;

import org.mapstruct.Mapper;
import springAdvanced.startingLesson.dtos.UsersCreateDTO;
import springAdvanced.startingLesson.entity.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users fromCreateDTO(UsersCreateDTO dto);
}
