package pl.coderslab.gamerater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.gamerater.model.Genre;
import pl.coderslab.gamerater.model.Publisher;
import pl.coderslab.gamerater.repository.PublisherRepository;
import pl.coderslab.gamerater.service.BaseService;

import java.util.List;

@Service
public class PublisherService implements BaseService<Publisher, Long> {

  private final PublisherRepository publisherRepository;

  @Autowired
  public PublisherService(PublisherRepository publisherRepository) {
    this.publisherRepository = publisherRepository;
  }

  public List<Publisher> getAll() {
    return publisherRepository.findAll();
  }

  public Publisher findById(Long id) {
    return publisherRepository.findById(id).get();
  }

  public Publisher save(Publisher publisher) {
    return publisherRepository.save(publisher);
  }

  public Publisher updateById(Long id) {
    Publisher publisher = publisherRepository.getOne(id);
    return publisherRepository.save(publisher);
  }

  public void removeById(Long id) {
    Publisher publisher = publisherRepository.findById(id).get();
    publisherRepository.delete(publisher);
  }
}
