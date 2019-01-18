package pl.coderslab.gamerater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gamerater.model.Game;
import pl.coderslab.gamerater.model.Role;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findAllByGenre(String genre);
    List<Game> findAllByRating(String rating);
}
