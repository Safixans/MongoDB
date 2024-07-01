package springAdvanced.assignment.service;

import java.util.Map;

public interface EmailSenderService {
    void sendVerificationMail(Map<Object, Object> model);

    boolean turnOnOrOfSMPTServer();

    boolean isSMPTActive();
}
