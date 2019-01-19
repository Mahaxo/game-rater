package pl.coderslab.gamerater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.gamerater.model.Role;
import pl.coderslab.gamerater.model.User;
import pl.coderslab.gamerater.repository.RoleRepository;
import pl.coderslab.gamerater.repository.UserRepository;
import pl.coderslab.gamerater.service.BaseService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService implements BaseService<User, Long> {

    final private UserRepository userRepository;
    final private BCryptPasswordEncoder bCryptPasswordEncoder;
    final private RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

  public User save(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    if (userRepository.findAll().isEmpty()) {
      Role role = roleRepository.findByRole("ADMIN");
      user.setRoles(new HashSet<>(Arrays.asList(role)));
    } else {
      Role role = roleRepository.findByRole("USER");
      user.setRoles(new HashSet<>(Arrays.asList(role)));
    }
      return userRepository.save(user);
    }

    public User updateById(Long id) {
        User user = userRepository.getOne(id);
        return userRepository.save(user);
    }

    public void removeById(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User checkCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userRepository.findByUsername(auth.getName());
        if (user == null) {
            throw new UsernameNotFoundException("You are not authorized, please login or register");
        }

        return user;
    }







}
