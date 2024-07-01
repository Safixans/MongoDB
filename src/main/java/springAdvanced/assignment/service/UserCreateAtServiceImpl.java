package springAdvanced.assignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springAdvanced.assignment.entity.Userss;
import springAdvanced.assignment.repo.UserRepository;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserCreateAtServiceImpl implements UserCreateAtService {
    private final UserRepository userRepository;

    @Override
    public void setCreatedAt(Userss userss) {
        userss.setCreatedAt(Instant.now());
        userRepository.save(userss);
    }
}
