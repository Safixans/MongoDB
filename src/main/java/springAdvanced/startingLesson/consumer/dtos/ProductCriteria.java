package springAdvanced.startingLesson.consumer.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductCriteria {
    private Long page;
    private Long size;
}
