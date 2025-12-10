package se.jensen.elias.javaspringbootdemo.dto.response;

import java.util.List;

public record UserResponseDTO(
        Long id,
        String name,
        List<PostResponseDTO> posts
) {
}
