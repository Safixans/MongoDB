package springAdvanced.assignment.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springAdvanced.assignment.dtos.UserCreateDTO;
import springAdvanced.assignment.dtos.UserUpdateDTO;
import springAdvanced.assignment.entity.Userss;
import springAdvanced.assignment.events.UserCreatedEvent;
import springAdvanced.assignment.events.UserUpdatedEvent;
import springAdvanced.assignment.mappers.UserMapper;
import springAdvanced.assignment.repo.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    @Transactional
    public Userss createUser(UserCreateDTO dto) {
        Userss userss = userMapper.fromCreateDTOUser(dto);
        userRepository.save(userss);
        eventPublisher.publishEvent(new UserCreatedEvent(userss.getUserId()));
        return userss;
    }

    @Override
    @Transactional
    public Userss updateUser(Integer id, UserUpdateDTO userUpdateDTO) {
        Userss userss = userRepository
                .findById(id)
                .orElseThrow();


        if (userss.getUserId().equals(id)) {
            log.info("Updating user with id: " + id);

            userss.setName(userUpdateDTO.getName());
            userss.setAge(userUpdateDTO.getAge());
//            userMapper.fromUpdateDTOUser(userUpdateDTO);
            userRepository.save(userss);
            eventPublisher.publishEvent(new UserUpdatedEvent(userss.getUserId()));
            log.info("User updated successfully {}", id);
        } else
            throw new RuntimeException("Invalid user id");
        return userss;
    }

    @Override
    public List<Userss> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        log.info("Deleting user with id: " + id);
        Userss userss = userRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with given id : " + id));
        userRepository.deleteById(id);
        log.info("User deleted successfully {}", id);
    }
}
