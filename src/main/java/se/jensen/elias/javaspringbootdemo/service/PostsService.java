package se.jensen.elias.javaspringbootdemo.service;

import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;

import java.util.List;

public interface PostsService {
    List<PostResponseDTO> getAllPosts();

    PostResponseDTO createPost(Long userId, PostRequestDTO request);

    PostResponseDTO getPostById(Long id);

    PostResponseDTO updatePostById(Long id, PostRequestDTO newPost);

    void deletePostById(Long id);

    void deleteAllPosts();


}
