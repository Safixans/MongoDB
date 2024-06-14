package springAdvanced.startingLesson.post.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import springAdvanced.startingLesson.post.Post;

import java.io.Serializable;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDTO implements Serializable {
    private Integer id;
    private String title;
    private String body;
    private List<CommentDTO> comments;

}