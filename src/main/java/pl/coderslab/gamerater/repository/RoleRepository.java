package pl.coderslab.gamerater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gamerater.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}
