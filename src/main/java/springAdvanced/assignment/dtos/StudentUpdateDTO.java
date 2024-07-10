package springAdvanced.assignment.dtos;

import lombok.*;

@Getter
@Setter
@Builder
public record StudentUpdateDTO(String name, int age){}


