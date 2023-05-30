package by.example.emercomMVC.repository;

import by.example.emercomMVC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
