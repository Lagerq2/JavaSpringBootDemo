package se.jensen.elias.javaspringbootdemo.dto.response;

import java.util.List;

public record UserWithPostResponseDTO(
        UserResponseDTO user,
        List<PostResponseDTO> posts
) {
}
