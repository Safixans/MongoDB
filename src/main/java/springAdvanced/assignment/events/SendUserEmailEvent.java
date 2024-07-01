package springAdvanced.assignment.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public final class SendUserEmailEvent {
    private final Integer id;
    private final String mail;
}
