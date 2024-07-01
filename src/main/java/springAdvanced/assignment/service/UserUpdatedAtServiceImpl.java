package springAdvanced.assignment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springAdvanced.assignment.entity.Userss;
import springAdvanced.assignment.repo.UserRepository;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserUpdatedAtServiceImpl implements UserUpdatedAtService{
    private final UserRepository userRepository;
    @Override
    public void updateUserUpdatedAt(Userss userss) {
        userss.setUpdatedAt(Instant.now());
        userRepository.save(userss);
    }
}
