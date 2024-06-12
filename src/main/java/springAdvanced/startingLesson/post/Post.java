package springAdvanced.startingLesson.post;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document("posts")
public class Post {

    @Id
    private String postId;
    @Field("post_title") /// to change the field nam on the database
    /*@Indexed(name = "post_title_unique_index",
            unique = true, // checks for uniqueness
            sparse = true)// sparse=true -> post_title yoq bolgan fieldlariga index yaratmasdan otib ketadi*/
    private String title;
    @Field("post_body")
    private String body;
    private Integer userId;
    private Integer id;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @CreatedBy
    private Long createdBy;
    @LastModifiedBy
    private Long updatedBy;


}
