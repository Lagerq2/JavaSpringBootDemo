package se.jensen.elias.javaspringbootdemo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "Name cannot be blank")
        @Size(min = 1, max = 50)
        String name
) {
}
