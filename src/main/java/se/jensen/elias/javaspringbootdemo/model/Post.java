package se.jensen.elias.javaspringbootdemo.model;

import java.time.LocalDateTime;

public class Post {
    private Long id = 0L;
    private String content;
    private LocalDateTime createdAt;
    private User user;

    public Post() {
    }

    public Post(String content, User user) {
        this.content = content;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
