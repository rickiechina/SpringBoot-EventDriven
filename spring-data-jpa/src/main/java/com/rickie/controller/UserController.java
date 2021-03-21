package com.rickie.controller;

import com.rickie.domain.model.User;
import com.rickie.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/add")
    public User addUser(@RequestParam String name, @RequestParam String email) {
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        return userRepository.save(user);
    }

    @GetMapping("/get")
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/getByName")
    public User getByName(@RequestParam String name) {
        return userRepository.findByName(name);
    }

    @GetMapping("/getByNameLike")
    public User getByNameLike(@RequestParam String name) {
        return userRepository.findByNameLike(name);
    }

    @PostMapping("/updateById")
    public int updateById(@RequestParam String name, @RequestParam Long id) {
        return userRepository.modifyById(name, id);
    }

    @GetMapping("/getByEmail")
    public List<User> getByEmail(@RequestParam String email) {
        return userRepository.findByEmail(email);
    }
}
