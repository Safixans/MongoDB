package springAdvanced.startingLesson.consumer.dtos;


import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDTO {
    private Integer id;
    private String name;
    private String description;
    private Double price;
    private LocalDateTime date;
}
