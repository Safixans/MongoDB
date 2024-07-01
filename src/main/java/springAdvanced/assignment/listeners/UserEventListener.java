package springAdvanced.assignment.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import springAdvanced.assignment.entity.Userss;
import springAdvanced.assignment.events.UserCreatedEvent;
import springAdvanced.assignment.events.UserUpdatedEvent;
import springAdvanced.assignment.repo.UserRepository;
import springAdvanced.assignment.service.EmailSenderService;
import springAdvanced.assignment.service.UserCreateAtService;
import springAdvanced.assignment.service.UserUpdatedAtService;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserEventListener {
    private final UserRepository userRepository;
    private final EmailSenderService emailSenderService;
    private final UserUpdatedAtService updatedEvent;
    private final UserCreateAtService createdEvent;

    @EventListener
    public void handlerUserCreatedEvent(UserCreatedEvent userCreatedEvent) {
        Userss userss = userRepository
                .findById(userCreatedEvent
                        .getUserID())
                .orElseThrow();
        createdEvent.setCreatedAt(userss);
        userRepository.save(userss);
        log.info("Userss created at: {}", userss.getCreatedAt());
    }

    @EventListener
    public void handlerUserUpdateAtEvent(UserUpdatedEvent userCreatedEvent) {
        Userss userss = userRepository
                .findById(userCreatedEvent
                        .getUserId())
                .orElseThrow();
        updatedEvent.updateUserUpdatedAt(userss);
        userRepository.save(userss);
        log.info("Userss updated at: {}", userss.getUpdatedAt());
        log.info("Userss : {}", userss);
    }



}
