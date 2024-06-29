package springAdvanced.startingLesson.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public final class SendMailEvent {
    private final Integer id;
    private final String mail;
    private final String otp;
}
