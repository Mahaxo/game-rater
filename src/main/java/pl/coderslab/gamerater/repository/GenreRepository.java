package pl.coderslab.gamerater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gamerater.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
