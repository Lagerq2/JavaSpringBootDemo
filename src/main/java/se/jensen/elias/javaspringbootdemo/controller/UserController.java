package se.jensen.elias.javaspringbootdemo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.request.UserRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.UserResponseDTO;
import se.jensen.elias.javaspringbootdemo.service.PostsService;
import se.jensen.elias.javaspringbootdemo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final PostsService postsService;

    public UserController(UserService userService, PostsService postsService) {
        this.userService = userService;
        this.postsService = postsService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(request));
    }

    @PostMapping("/{userId}/posts")
    public ResponseEntity<PostResponseDTO> createPostForUser(
            @PathVariable Long userId,
            @Valid @RequestBody PostRequestDTO newPost
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postsService.createPost(userId, newPost));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok(userService.getUserById(id));

    }
}
