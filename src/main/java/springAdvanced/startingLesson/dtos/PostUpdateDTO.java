package springAdvanced.startingLesson.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link springAdvanced.startingLesson.entity.Post}
 */
@Value
public class PostUpdateDTO implements Serializable {
    Integer id;
    String title;
    String body;
}