package springAdvanced.startingLesson.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springAdvanced.startingLesson.dtos.UsersCreateDTO;
import springAdvanced.startingLesson.entity.Users;
import springAdvanced.startingLesson.events.OtpGenerateEvent;
import springAdvanced.startingLesson.mapper.UserMapper;
import springAdvanced.startingLesson.repository.UsersRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {


    private final UserMapper userMapper;
    private final UsersRepository usersRepository;
    private final ApplicationEventPublisher eventPublisher;
//    private final OtpGenerateService otpGenerateService;

    @Override
    @Transactional
    public Users create(UsersCreateDTO dto) {
        Users users = userMapper.fromCreateDTO(dto);
        usersRepository.save(users);
//        otpGenerateService.generateOtp(users);  bu ozi alohida logic single responsibilty dgan principle ni buzvotti
        // shunichun biza EOP ishlatamiz for decoupling
        eventPublisher.publishEvent(new OtpGenerateEvent(users));// event rise bovotti this class dan
        return users;
    }
}
