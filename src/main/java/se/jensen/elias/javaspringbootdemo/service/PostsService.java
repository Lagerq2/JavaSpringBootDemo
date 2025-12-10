package se.jensen.elias.javaspringbootdemo.service;

import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;

import java.util.List;

public interface PostsService {
    List<PostResponseDTO> getAllPosts();

    PostResponseDTO createPost(PostRequestDTO request);

    PostResponseDTO getPostById(int index);

    PostResponseDTO updatePostById(int index, PostRequestDTO newPost);

    void deletePostById(int index);

    void deleteAllPosts();


}
