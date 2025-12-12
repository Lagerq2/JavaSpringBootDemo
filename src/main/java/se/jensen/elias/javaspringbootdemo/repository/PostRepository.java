package se.jensen.elias.javaspringbootdemo.repository;

import org.springframework.stereotype.Repository;
import se.jensen.elias.javaspringbootdemo.model.Post;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private final List<Post> posts = new ArrayList<>();


    public List<Post> getAllPosts() {
        return posts;
    }

    public void saveCreatedPost(Post post) {
        posts.add(post);
        

    }

    public Post getPostById(Long id) {
        return posts.stream().
                filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void updatePost(Post post, String newContent) {
        post.setContent(newContent);
    }

    public void deletePostById(Long id) {
        posts.removeIf(p -> p.getId().equals(id));
    }

    public void deleteAllPosts() {
        posts.clear();
    }
}
