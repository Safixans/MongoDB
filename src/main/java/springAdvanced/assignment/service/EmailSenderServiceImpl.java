package springAdvanced.assignment.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Slf4j
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private final UserCacheService userCacheService;
    private boolean on = false;

    @Override
    public void sendVerificationMail(Map<Object, Object> model) {
        if (on) {
            log.info("Connecting to SMTP server...");
            log.info("Sending EMAIL verification mail... to {}", model);
        } else
            log.info("Sending EMAIL verification mail... to {}", model);

        userCacheService.put(model);

    }

    @Override
    public boolean turnOnOrOfSMPTServer() {
        this.on = !on;
        return this.on;
    }

    @Override
    public boolean isSMPTActive() {
        return this.on;
    }
}
