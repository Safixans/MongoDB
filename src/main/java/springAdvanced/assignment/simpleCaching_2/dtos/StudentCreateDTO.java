package springAdvanced.assignment.simpleCaching_2.dtos;

import springAdvanced.assignment.simpleCaching_2.entity.Student;

/**
 * DTO for {@link Student}
 */

public record StudentCreateDTO(String name, int age) {
}