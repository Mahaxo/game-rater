package pl.coderslab.gamerater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gamerater.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
