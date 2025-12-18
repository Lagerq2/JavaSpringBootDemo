package se.jensen.elias.javaspringbootdemo.controller;

import jakarta.validation.Valid;
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


    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDTO> getPostById(@PathVariable Long id) {
        return ResponseEntity.ok(postsService.getPostById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDTO> updatePostById(
            @PathVariable Long id,
            @Valid @RequestBody PostRequestDTO newPost
    ) {
        return ResponseEntity.ok(postsService.updatePostById(id, newPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long id) {
        postsService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAllPosts() {
        postsService.deleteAllPosts();
        return ResponseEntity.noContent().build();
    }
}
