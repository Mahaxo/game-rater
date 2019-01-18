package pl.coderslab.gamerater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.gamerater.model.Game;

import pl.coderslab.gamerater.repository.GameRepository;
import pl.coderslab.gamerater.service.BaseService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class GameService implements BaseService<Game, Long> {

    final private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;

    }

    public List<Game> getAll() {

        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id).get();
    }

    public Game save(Game game) {

        return gameRepository.save(game);
    }

    public Game updateById(Long id) {
        Game game = gameRepository.getOne(id);
        return gameRepository.save(game);
    }

    public void removeById(Long id) {
        Game game = gameRepository.findById(id).get();
        gameRepository.delete(game);
    }


}
