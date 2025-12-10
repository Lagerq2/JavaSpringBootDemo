package se.jensen.elias.javaspringbootdemo.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "Name cannot be blank") String name
) {
}
