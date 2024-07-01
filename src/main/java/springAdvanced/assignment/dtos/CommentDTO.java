package springAdvanced.assignment.dtos;

import lombok.*;
import springAdvanced.assignment.entity.Blog;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
public class CommentDTO {
    private String author;
    private String message;
    private Blog blog;
}
