package se.jensen.elias.javaspringbootdemo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PostRequestDTO(
        @NotBlank(message = "Text cannot be blank")
        @Size(min = 3, max = 200)
        String text
) {
}
