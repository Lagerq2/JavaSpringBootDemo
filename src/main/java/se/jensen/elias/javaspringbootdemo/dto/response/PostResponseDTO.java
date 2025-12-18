package se.jensen.elias.javaspringbootdemo.dto.response;

import java.time.LocalDateTime;

public record PostResponseDTO(
        Long id,
        String content,
        Long userId,
        String displayName,
        LocalDateTime createdAt
) {
}