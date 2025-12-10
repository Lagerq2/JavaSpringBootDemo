package se.jensen.elias.javaspringbootdemo.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
import se.jensen.elias.javaspringbootdemo.service.PostsService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostsService postsService;

    public PostController(PostsService service) {
        this.postsService = service;
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDTO>> getAllPosts() {
        return ResponseEntity.ok(postsService.getAllPosts());
    }

    @PostMapping
    public ResponseEntity<PostResponseDTO> createPost(
            @Valid @RequestBody PostRequestDTO request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(postsService.createPost(request));
    }

    @GetMapping("/{index}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable int index) {
        return ResponseEntity.ok(postsService.getPostById(index));
    }

    @PutMapping("/{index}")
    public ResponseEntity<PostResponseDTO> updatePostById(
            @PathVariable int index,
            @Valid @RequestBody PostRequestDTO newPost
    ) {
        return ResponseEntity.ok(postsService.updatePostById(index, newPost));
    }

    @DeleteMapping("/{index}")
    public ResponseEntity<Void> deletePostById(@PathVariable int index) {
        postsService.deletePostById(index);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllPosts() {
        postsService.deleteAllPosts();
        return ResponseEntity.noContent().build();
    }
}
