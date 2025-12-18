package se.jensen.elias.javaspringbootdemo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequestDTO(
        @NotBlank(message = "Name cannot be blank")
        @Size(min = 1, max = 50)
        String username,

        @NotBlank(message = "Email cannot be empty")
        @Email
        String email,

        @NotBlank(message = "Password cannot be empty")
        @Size(min = 6, max = 20)
        String password,

        @NotBlank(message = "Role cannot be empty")
        String role,

        @NotBlank(message = "Display name cannot be empty")
        String displayName,

        @NotBlank(message = "Bio cannot be empty")
        String bio,

        String profilePicture

) {
}
