package pl.coderslab.gamerater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.gamerater.model.Genre;
import pl.coderslab.gamerater.model.Platform;
import pl.coderslab.gamerater.repository.PlatformRepository;
import pl.coderslab.gamerater.service.BaseService;

import java.util.List;

@Service
public class PlatformService implements BaseService<Platform, Long> {

  private final PlatformRepository platformRepository;

  @Autowired
  public PlatformService(PlatformRepository platformRepository) {
    this.platformRepository = platformRepository;
  }

  public List<Platform> getAll() {
    return platformRepository.findAll();
  }

  public Platform findById(Long id) {
    return platformRepository.findById(id).get();
  }

  public Platform save(Platform platform) {
    return platformRepository.save(platform);
  }

  public Platform updateById(Long id) {
    Platform platform = platformRepository.getOne(id);
    return platformRepository.save(platform);
  }

  public void removeById(Long id) {
    Platform platform = platformRepository.findById(id).get();
    platformRepository.delete(platform);
  }
}
