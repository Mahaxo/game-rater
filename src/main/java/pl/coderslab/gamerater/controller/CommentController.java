package pl.coderslab.gamerater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.gamerater.model.Comment;
import pl.coderslab.gamerater.model.Game;
import pl.coderslab.gamerater.service.impl.CommentService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CommentController {

  private final CommentService commentService;

  @Autowired
  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @GetMapping("comment")
  public String showAllGames(Model model) {
    List<Comment> comments = commentService.getAll();
    model.addAttribute("comments", comments);
    return "viewAllComments";
  }
}