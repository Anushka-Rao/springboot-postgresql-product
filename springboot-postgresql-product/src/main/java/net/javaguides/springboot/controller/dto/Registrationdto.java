package net.javaguides.springboot.controller.dto;


import net.javaguides.springboot.Exception.ResourceNotFoundException;
import net.javaguides.springboot.dao.entity.User;
import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class Registrationdto {
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getAllUser(){
        return this.userService.findAll();
    }


}

