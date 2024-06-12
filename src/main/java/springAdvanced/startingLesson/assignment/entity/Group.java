package springAdvanced.startingLesson.assignment.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document("group")
public class Group {
    @Id
    private String id;
    private String name;

}
