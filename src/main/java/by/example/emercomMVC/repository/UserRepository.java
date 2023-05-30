package by.example.emercomMVC.repository;

import by.example.emercomMVC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByName(String name);

    @Query(nativeQuery = true, value = "SELECT password FROM users WHERE id = :id")
    String findPasswordById(@Param("id") Long id);
}
