package springAdvanced.assignment.events;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public final class UserUpdatedEvent {
    private final Integer userId;
}
