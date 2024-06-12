package springAdvanced.startingLesson.assignment.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import springAdvanced.startingLesson.assignment.enums.Gender;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document("student")
public class Student {
    @Id
    private String id;
    private String name;
    private Integer age;
    private String groupId;
    private Date birthDate;
    private Gender gender;


}
