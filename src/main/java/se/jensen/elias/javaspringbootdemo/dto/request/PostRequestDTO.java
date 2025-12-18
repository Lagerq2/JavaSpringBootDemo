package se.jensen.elias.javaspringbootdemo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostRequestDTO(
        @NotBlank(message = "Text cannot be blank")
        @NotNull()
        @Size(min = 1, max = 200)
        String text
) {
}
