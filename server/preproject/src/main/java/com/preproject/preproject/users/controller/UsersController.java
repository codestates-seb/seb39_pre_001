package com.preproject.preproject.users.controller;


import com.preproject.preproject.users.dto.UsersPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @PostMapping("/join")
    public ResponseEntity postUser(@RequestBody UsersPostDto usersPostDto) {

        return new ResponseEntity<>(usersPostDto, HttpStatus.CREATED);
    }

    @GetMapping("/join")
    public ResponseEntity getUser() {

        return new ResponseEntity<>("Welcome Join User", HttpStatus.OK);
    }
}
