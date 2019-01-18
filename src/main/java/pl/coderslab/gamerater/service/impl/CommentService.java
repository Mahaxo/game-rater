package pl.coderslab.gamerater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.gamerater.model.Comment;
import pl.coderslab.gamerater.repository.CommentRepository;
import pl.coderslab.gamerater.service.BaseService;

import java.util.List;

@Service
public class CommentService implements BaseService<Comment, Long> {

  private final CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commmentRepository) {
    this.commentRepository = commmentRepository;
  }

  public List<Comment> getAll() {
    return commentRepository.findAll();
  }

  public Comment findById(Long id) {
    return commentRepository.findById(id).get();
  }

  public Comment save(Comment comment) {
    return commentRepository.save(comment);
  }

  public Comment updateById(Long id) {
    Comment comment = commentRepository.getOne(id);
    return commentRepository.save(comment);
  }

  public void removeById(Long id) {
    Comment comment = commentRepository.findById(id).get();
    commentRepository.delete(comment);
  }
}
