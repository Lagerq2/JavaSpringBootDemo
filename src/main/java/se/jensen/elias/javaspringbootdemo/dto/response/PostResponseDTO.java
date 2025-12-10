package se.jensen.elias.javaspringbootdemo.dto.response;

import java.time.LocalDateTime;

public record PostResponseDTO(
        Long id,
        String text,
        LocalDateTime created
) {
}