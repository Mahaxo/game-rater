package pl.coderslab.gamerater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.gamerater.model.Genre;
import pl.coderslab.gamerater.model.Genre;
import pl.coderslab.gamerater.repository.GenreRepository;
import pl.coderslab.gamerater.service.BaseService;

import java.util.List;

@Service
public class GenreService implements BaseService<Genre, Long> {

  private final GenreRepository genreRepository;

  @Autowired
  public GenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  public List<Genre> getAll() {
    return genreRepository.findAll();
  }

  public Genre findById(Long id) {
    return genreRepository.findById(id).get();
  }

  public Genre save(Genre Genre) {
    return genreRepository.save(Genre);
  }

  public Genre updateById(Long id) {
    Genre Genre = genreRepository.getOne(id);
    return genreRepository.save(Genre);
  }

  public void removeById(Long id) {
    Genre Genre = genreRepository.findById(id).get();
    genreRepository.delete(Genre);
  }
}
