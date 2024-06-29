package springAdvanced.startingLesson.service;

import org.springframework.stereotype.Service;
import springAdvanced.startingLesson.entity.Users;

@Service
public interface OtpGenerateService {
    void generateOtp(Users users);
}
