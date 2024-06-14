package springAdvanced.startingLesson.post;


import jakarta.persistence.*;
import lombok.*;
import springAdvanced.startingLesson.post.dtos.CommentDTO;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;


}
