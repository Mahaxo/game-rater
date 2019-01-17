package pl.coderslab.gamerater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.gamerater.model.Game;
import pl.coderslab.gamerater.model.Genre;
import pl.coderslab.gamerater.service.impl.GameService;

import java.util.List;

@Controller
public class GameController {

    final private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("games")
    public String showAllGames(Model model) {
        List<Game> games = gameService.getAll();
        model.addAttribute("games", games);
        return "viewGames";
    }

    @GetMapping("games/{id}")
    public String showGameDetails(@PathVariable Long id, Model model) {
    Game game = gameService.findById(id);
    model.addAttribute("game", game);
    return "gameDetails";

    }
}
    /*
    @ModelAttribute("allGenres")
    public List<Genre> populateGenres() {
        return
}

    @GetMapping("browsegames/{id}")
    /public String getGameDetails



}
*/