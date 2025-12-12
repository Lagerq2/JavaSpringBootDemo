package se.jensen.elias.javaspringbootdemo.service.impl;

import org.springframework.stereotype.Service;
import se.jensen.elias.javaspringbootdemo.dto.request.UserRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.UserResponseDTO;
import se.jensen.elias.javaspringbootdemo.model.User;
import se.jensen.elias.javaspringbootdemo.repository.UserRepository;
import se.jensen.elias.javaspringbootdemo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private Long nextId = 1L;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {
        User user = new User(nextId++, request.name());
        userRepository.saveCreatedUser(user);
        return toResponseDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.getAllUsers().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return toResponseDTO(userRepository.getUserById(id));
    }

    private UserResponseDTO toResponseDTO(User user) {
        List<PostResponseDTO> posts = user.getPosts().stream()
                .map(post -> new PostResponseDTO(
                        post.getId(),
                        post.getContent(),
                        post.getCreatedAt()
                ))
                .toList();
        return new UserResponseDTO(user.getId(), user.getName(), posts);
    }
}
