package com.suiwei.controller;

import com.suiwei.entity.User;
import com.suiwei.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author suiwei
 * @date 2021-09-23 14:15
 */
@RestController
@RequestMapping("/jpa")
public class JpaController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        User user = userRepository.findById(id).orElse(null);
        return  user;
    }
    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepository.save(user);
        return  save;
    }
}
