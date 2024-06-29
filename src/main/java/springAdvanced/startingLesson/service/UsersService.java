package springAdvanced.startingLesson.service;

import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.dtos.UsersCreateDTO;
import springAdvanced.startingLesson.entity.Users;

@Service
public interface UsersService {
    Users create(UsersCreateDTO dto);
}
