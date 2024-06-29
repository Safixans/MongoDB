package springAdvanced.startingLesson.service;

import java.util.Map;

public interface MailService {
    void sendVerificationMail(Map<Object, Object> model);

    boolean turnOnOrOfSMPTServer();
    boolean isSMPTActive();
}
