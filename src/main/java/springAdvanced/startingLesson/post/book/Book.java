package springAdvanced.startingLesson.post.book;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document("books")
public class Book {

    @Id
    private String id;
    private String name;
    private String author;

}
