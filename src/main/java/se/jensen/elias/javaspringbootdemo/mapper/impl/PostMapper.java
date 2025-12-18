package se.jensen.elias.javaspringbootdemo.mapper.impl;

import org.springframework.stereotype.Component;
import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
import se.jensen.elias.javaspringbootdemo.model.Post;
import se.jensen.elias.javaspringbootdemo.model.User;

@Component
public class PostMapper {

    public PostResponseDTO toResponseDTO(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getContent(),
                post.getUser().getId(),
                post.getUser().getDisplayName(),
                post.getCreatedAt()
        );
    }

    public Post toEntity(PostRequestDTO dto, User user) {
        return new Post(dto.text(), user);
    }
}
