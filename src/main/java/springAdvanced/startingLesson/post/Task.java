package springAdvanced.startingLesson.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.spi.LocaleNameProvider;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task implements Serializable {
    private Integer id;
    private String title;
    private String description;
    private String label;
    private LocalDateTime createdAt;

}