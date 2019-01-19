package pl.coderslab.gamerater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.gamerater.model.Game;
import pl.coderslab.gamerater.model.Genre;
import pl.coderslab.gamerater.model.Platform;
import pl.coderslab.gamerater.model.Publisher;
import pl.coderslab.gamerater.service.impl.GameService;
import pl.coderslab.gamerater.service.impl.GenreService;
import pl.coderslab.gamerater.service.impl.PlatformService;
import pl.coderslab.gamerater.service.impl.PublisherService;


import javax.validation.Valid;
import java.util.List;

@Controller
public class GameController {

    final private GameService gameService;
    final private GenreService genreService;
    final private PublisherService publisherService;
    final private PlatformService platformService;

    @Autowired
    public GameController(GameService gameService, GenreService genreService, PublisherService publisherService, PlatformService platformService) {

        this.gameService = gameService;
        this.genreService = genreService;
        this.publisherService = publisherService;
        this.platformService = platformService;
    }

    @GetMapping("games")
    public String showAllGames(Model model) {
        List<Game> games = gameService.getAll();
        model.addAttribute("games", games);
        return "viewAllGames";
    }

    @GetMapping("games/{id}")
    public String showGameDetails(@PathVariable Long id, Model model) {
    Game game = gameService.findById(id);
    model.addAttribute("game", game);
    return "gameDetails";
    }

    @GetMapping("/add")
    public String addGame(Model model) {
        Game game = new Game();
        model.addAttribute("game", game);
        return "addGame";
    }

    @PostMapping("/add")
    public String addGame(@Valid @ModelAttribute Game game, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "addGame";
        }
        gameService.save(game);
        model.addAttribute("successMessage", "Game has been added successfully");
        model.addAttribute("game", new Game());
        return "addGame";
    }
    @GetMapping("games/edit/{id}")
    public String editGame(Model model, @PathVariable long id) {
        Game game = gameService.findById(id);
        model.addAttribute("game", game);
        return "editGame";
    }
    @PostMapping("games/edit/{id}")
    public String saveEditCategory(@Valid @ModelAttribute Game game, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "editGame";
        }
        gameService.save(game);
        model.addAttribute("game", new Game());
        model.addAttribute("successMessage", "Game has been edited successfully");
        return "editGame";
    }

    @ModelAttribute("genres")
    public List<Genre> populateGenres() {
        return genreService.getAll();
}

    @ModelAttribute("publishers")
    public List<Publisher> populatePublishers() {
        return publisherService.getAll();
    }

    @ModelAttribute("platforms")
    public List<Platform> populatePlatforms() {
        return platformService.getAll();
    }


}
