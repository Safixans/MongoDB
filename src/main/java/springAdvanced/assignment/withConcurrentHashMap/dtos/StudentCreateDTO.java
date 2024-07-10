package springAdvanced.assignment.withConcurrentHashMap.dtos;

import springAdvanced.assignment.withConcurrentHashMap.entity.Student;

/**
 * DTO for {@link Student}
 */

public record StudentCreateDTO(String name, int age) {
}