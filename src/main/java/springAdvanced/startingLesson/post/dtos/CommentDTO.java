package springAdvanced.startingLesson.post.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer id;
    private String message;
    private Integer postId;
}