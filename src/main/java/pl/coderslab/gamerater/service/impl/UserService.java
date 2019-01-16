package pl.coderslab.gamerater.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    RoleRepository roleRepository;


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<>(Arrays.asList(role)));
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

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



}