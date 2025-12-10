package se.jensen.elias.javaspringbootdemo.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private List<Post> posts = new ArrayList<>();

    public User() {

    }

    public User(Long id, String username) {
        this.id = id;
        this.name = username;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addPosts(Post post) {
        this.posts.add(post);
    }
}
