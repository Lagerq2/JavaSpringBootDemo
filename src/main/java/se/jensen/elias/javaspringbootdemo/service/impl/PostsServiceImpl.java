package se.jensen.elias.javaspringbootdemo.service.impl;

import org.springframework.stereotype.Service;
import se.jensen.elias.javaspringbootdemo.dto.request.PostRequestDTO;
import se.jensen.elias.javaspringbootdemo.dto.response.PostResponseDTO;
import se.jensen.elias.javaspringbootdemo.model.Post;
import se.jensen.elias.javaspringbootdemo.service.PostsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {
    private final List<Post> posts = new ArrayList<>();

    @Override
    public List<PostResponseDTO> getAllPosts() {
        return posts.stream()
                .map(this::toResponseDTO)
                .toList();
    }

    @Override
    public PostResponseDTO createPost(PostRequestDTO request) {
        Post post = new Post(request.text());
        posts.add(post);
        return toResponseDTO(post);
    }

    @Override
    public PostResponseDTO getPostById(int index) {
        if (index < 0 || index >= posts.size()) {
            throw new IndexOutOfBoundsException("Post not found");
        }
        return toResponseDTO(posts.get(index));
    }

    @Override
    public PostResponseDTO updatePostById(int index, PostRequestDTO newPost) {
        if (index < 0 || index >= posts.size()) {
            throw new IndexOutOfBoundsException("Post not found");
        }
        Post existing = posts.get(index);
        existing.setContent(newPost.text());
        return toResponseDTO(existing);
    }

    @Override
    public void deletePostById(int index) {
        if (index < 0 || index >= posts.size()) {
            throw new IndexOutOfBoundsException("Post not found");
        }
        posts.remove(index);
    }

    @Override
    public void deleteAllPosts() {
        posts.clear();
    }

    private PostResponseDTO toResponseDTO(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getContent(),
                post.getCreatedAt()
        );
    }
}
