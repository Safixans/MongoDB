package springAdvanced.startingLesson.assignment.dtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class StudentUpdateDto {
    private String name;
    private Integer age;
}
