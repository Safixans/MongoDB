package springAdvanced.startingLesson.events;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.context.ApplicationEvent;
import springAdvanced.startingLesson.entity.Users;

@RequiredArgsConstructor
@Getter
//@Value // hammasini final qberadi ozi
/***
 4.2 version dan keyin extend olib otirish shartamas,
 uni qmastan turib ishlatsayam bolad
 ***/
public final class OtpGenerateEvent/* extends ApplicationEvent*/ {
    //event should be immutable (final)
    private final Users users;/*
    public OtpGenerateEvent(Object source, Users users) {
        super(source);
        this.users = users;
    }*/
/*
    public Users getUsers() {
        return users;
    }*/
}
