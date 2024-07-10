package springAdvanced.assignment.dtos;

import lombok.Value;

/**
 * DTO for {@link springAdvanced.assignment.entity.Student}
 */

public record StudentCreateDTO(String name, int age) {
}