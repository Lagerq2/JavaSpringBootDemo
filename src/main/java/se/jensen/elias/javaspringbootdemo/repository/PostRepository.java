package se.jensen.elias.javaspringbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jensen.elias.javaspringbootdemo.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}


