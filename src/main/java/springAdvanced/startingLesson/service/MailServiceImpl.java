package springAdvanced.startingLesson.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class MailServiceImpl implements MailService {
    private boolean on = false;
    private final CacheService cacheService;

    public MailServiceImpl(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @Override
    public void sendVerificationMail(Map<Object, Object> model) {
        if (on) {
            log.info("connecting to SMPT server");
            log.info("Sending MAIL {}", model);
        } else
            log.info("Caching MAIL  MODEL {}", model);
        cacheService.put(model);
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
