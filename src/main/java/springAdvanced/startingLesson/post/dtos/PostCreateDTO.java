package springAdvanced.startingLesson.post.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springAdvanced.startingLesson.post.Post;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateDTO implements Serializable {
    private String title;
    private String body;
}