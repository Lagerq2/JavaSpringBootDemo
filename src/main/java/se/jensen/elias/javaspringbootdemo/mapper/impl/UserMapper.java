package se.jensen.elias.javaspringbootdemo.mapper.impl;

import org.springframework.stereotype.Component;
import se.jensen.elias.javaspringbootdemo.dto.request.UserRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.UserResponseDTO;
import se.jensen.elias.javaspringbootdemo.mapper.RequestMapper;
import se.jensen.elias.javaspringbootdemo.mapper.ResponseMapper;
import se.jensen.elias.javaspringbootdemo.model.User;

import java.util.List;

@Component
public class UserMapper implements ResponseMapper<User, UserResponseDTO>,
        RequestMapper<User, UserRequestDTO> {

    private final PostMapper postMapper;

    public UserMapper(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public UserResponseDTO toResponseDTO(User user) {
        List<PostResponseDTO> posts = user.getPosts().stream()
                .map(postMapper::toResponseDTO)
                .toList();

        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                user.getDisplayName(),
                user.getBio(),
                user.getProfilePicture()
        );
    }

    @Override
    public User toEntity(UserRequestDTO dto) {
        return User.createUser(
                dto.username(),
                dto.email(),
                dto.password(),
                dto.displayName(),
                dto.bio(),
                dto.profilePicture()
        );
    }
}
