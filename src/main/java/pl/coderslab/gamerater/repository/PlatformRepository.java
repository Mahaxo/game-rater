package pl.coderslab.gamerater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gamerater.model.Platform;

public interface PlatformRepository extends JpaRepository<Platform, Long> {

}
