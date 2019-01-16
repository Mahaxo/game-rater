package pl.coderslab.gamerater.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.gamerater.model.User;
import pl.coderslab.gamerater.service.impl.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

  @Autowired
  private UserService userService;

  @GetMapping({"/login", "/"})
  public String login() {
    return "login";
  }

  @GetMapping("/registration")
  public String registration(Model model) {
    User user = new User();
    model.addAttribute("user", user);
    return "register";
  }

  @PostMapping("/registration")
  public String createUser(@Valid User user, BindingResult bindingResult, Model model) {
    User userExists = userService.findByEmail(user.getEmail());
    if (userExists != null) {
      bindingResult.rejectValue(
          "email", "error.user", "User already exists!");
    }
    if (bindingResult.hasErrors()) {
      return "register";
    } else {
      userService.save(user);
      model.addAttribute("successMessage", "User has been registered successfully");
      model.addAttribute("user", new User());
      return "register";
    }
  }

  @GetMapping("/admin/home")
  public ModelAndView home(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    User user = userService.findByEmail(auth.getName());
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + "(" + user.getEmail() + ")");
    modelAndView.addObject("adminMessage", "Only for the Boss!");
    modelAndView.setViewName("admin/home");
    return modelAndView;
  }
}
