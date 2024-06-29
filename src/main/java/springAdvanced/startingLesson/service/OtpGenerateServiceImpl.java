package springAdvanced.startingLesson.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.entity.Users;
import springAdvanced.startingLesson.repository.UsersRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OtpGenerateServiceImpl implements OtpGenerateService {
    private final UsersRepository usersRepository;

    @Override
    public void generateOtp(Users user) {
        user.setOtp(UUID.randomUUID().toString());
        usersRepository.save(user);
    }
}
