package springAdvanced.startingLesson.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for {@link springAdvanced.startingLesson.entity.Users}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsersCreateDTO {
    private String email;
    private String username;
    private String password;
}