package springAdvanced.assignment.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class UserCreatedEvent {
    private final Integer userID;
}
