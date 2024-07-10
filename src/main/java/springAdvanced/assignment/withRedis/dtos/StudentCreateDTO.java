package springAdvanced.assignment.withRedis.dtos;

import springAdvanced.assignment.withRedis.entity.Student;

/**
 * DTO for {@link Student}
 */

public record StudentCreateDTO(String name, int age) {
}