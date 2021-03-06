package pl.coderslab.gamerater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gamerater.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
