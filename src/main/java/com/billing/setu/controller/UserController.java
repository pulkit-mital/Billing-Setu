package com.billing.setu.controller;

import com.billing.setu.document.Users;
import com.billing.setu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/all")
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }
}
