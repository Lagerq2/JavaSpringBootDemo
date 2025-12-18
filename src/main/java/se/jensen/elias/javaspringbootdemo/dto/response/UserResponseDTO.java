package se.jensen.elias.javaspringbootdemo.dto.response;

public record UserResponseDTO(
        Long id,
        String username,
        String email,
        String role,
        String displayName,
        String bio,
        String profilePicture
) {
}
