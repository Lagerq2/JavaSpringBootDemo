package se.jensen.elias.javaspringbootdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.jensen.elias.javaspringbootdemo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
