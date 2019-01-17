package pl.coderslab.gamerater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.gamerater.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
