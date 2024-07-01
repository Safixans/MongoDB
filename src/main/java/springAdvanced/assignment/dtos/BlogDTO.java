package springAdvanced.assignment.dtos;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class BlogDTO {
    private String title;
    private String description;
}
