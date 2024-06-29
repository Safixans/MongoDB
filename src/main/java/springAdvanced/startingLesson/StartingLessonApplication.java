package springAdvanced.startingLesson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import springAdvanced.startingLesson.service.CacheService;
import springAdvanced.startingLesson.service.MailService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@EnableAsync
@EnableScheduling
@Slf4j
@RequiredArgsConstructor
public class StartingLessonApplication {

    private final CacheService cacheService;
    private final MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(StartingLessonApplication.class, args);
    }

    @Scheduled(initialDelay = 5, fixedDelay = 60, timeUnit = TimeUnit.SECONDS)
    public void scheduledTask() {

        if (mailService.isSMPTActive()) {
            ConcurrentHashMap<Object, Map<Object, Object>> cache = cacheService.getCache();
            cache.forEach((k, v) -> {
            mailService.sendVerificationMail(v);
            cache.remove(k);
            });
        }else
            log.info("SMTP server is off");


    }
}
