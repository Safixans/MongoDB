package springAdvanced.startingLesson.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import springAdvanced.startingLesson.entity.Users;
import springAdvanced.startingLesson.events.OtpGenerateEvent;
import springAdvanced.startingLesson.events.SendMailEvent;
import springAdvanced.startingLesson.service.MailService;
import springAdvanced.startingLesson.service.OtpGenerateService;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
@RequiredArgsConstructor
public class UsersEventListeners {
    private final OtpGenerateService otpGenerateService;
    private final MailService mailService;

    //exception otsa rollback bop ketmidi ushanda
    /*@TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,
            condition = "#event.users.email ne  null ")
    @Transactional(propagation = Propagation.REQUIRES_NEW)*/
    @EventListener({OtpGenerateEvent.class})
    @Async
    /*@Order(1)*/
    public /*void*/ CompletableFuture<SendMailEvent> generateOtpEventListener(OtpGenerateEvent event) throws InterruptedException {
        Users users = event.getUsers();
//        TimeUnit.SECONDS.sleep(8);
        otpGenerateService.generateOtp(users);
        log.info("OTP Generated  with : {}", users);
//        usersRepository.save(users);
//        throw new RuntimeException("Test exception for EOP ");
        return CompletableFuture.completedFuture(new SendMailEvent(users.getId(), users.getEmail(), users.getOtp()));
    }

    @EventListener({SendMailEvent.class})
    /*@Order(2)*/
    public void verificationMailSenderListener(SendMailEvent event) {
        log.info("Mail sent to : {}", event);
        Map<Object, Object> model = Map.of(
                "userID", event.getId(),
                "email", event.getMail(),
                "otp", event.getOtp()
        );
        mailService.sendVerificationMail(model);
        // smpt
        // mail send
        //  shutdown
    }
}
