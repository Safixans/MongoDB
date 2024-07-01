package springAdvanced.assignment.mappers;

import org.mapstruct.Mapper;
import springAdvanced.assignment.dtos.UserCreateDTO;
import springAdvanced.assignment.dtos.UserUpdateDTO;
import springAdvanced.assignment.entity.Userss;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Userss fromCreateDTOUser(UserCreateDTO userDto);
    Userss fromUpdateDTOUser(UserUpdateDTO userDto);
}
