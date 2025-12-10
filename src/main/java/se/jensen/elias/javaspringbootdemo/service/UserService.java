package se.jensen.elias.javaspringbootdemo.service;

import se.jensen.elias.javaspringbootdemo.dto.request.UserRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {


    UserResponseDTO createUser(UserRequestDTO request);

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);


}
