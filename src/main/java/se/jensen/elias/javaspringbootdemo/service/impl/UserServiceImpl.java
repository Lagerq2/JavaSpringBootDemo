package se.jensen.elias.javaspringbootdemo.service.impl;

import org.springframework.stereotype.Service;
import se.jensen.elias.javaspringbootdemo.dto.request.UserRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.UserResponseDTO;
import se.jensen.elias.javaspringbootdemo.mapper.impl.UserMapper;
import se.jensen.elias.javaspringbootdemo.model.User;
import se.jensen.elias.javaspringbootdemo.repository.UserRepository;
import se.jensen.elias.javaspringbootdemo.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private Long nextId;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO request) {

        User user = userMapper.toEntity(request);
        User savedUser = userRepository.save(user);

        return userMapper.toResponseDTO(savedUser);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toResponseDTO)
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toResponseDTO)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
