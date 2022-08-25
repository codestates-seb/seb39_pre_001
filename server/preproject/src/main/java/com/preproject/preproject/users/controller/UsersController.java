package com.preproject.preproject.users.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/new-user")
    public ResponseEntity postUser() {

        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }
}
