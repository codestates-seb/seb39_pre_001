package com.preproject.preproject.users.controller;


import com.preproject.preproject.users.dto.UserLoginDto;
import com.preproject.preproject.users.dto.UsersPostDto;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.mapper.UserMapper;
import com.preproject.preproject.users.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    private final UserService userService;

    private final UserMapper userMapper;

    public UsersController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/join")
    public ResponseEntity postUser(@RequestBody UsersPostDto usersPostDto) {
        Users users = userMapper.userPost(usersPostDto);

        Users response = userService.createUser(users);

        return new ResponseEntity(userMapper.userResponse(response), HttpStatus.CREATED);
    }

    @GetMapping("/join")
    public ResponseEntity getUser() {

        return new ResponseEntity<>("Welcome Join User", HttpStatus.OK);
    }

    //login 기능
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDto loginDto) {
        log.info("email = {} , password = {} ", loginDto.getEmail(), loginDto.getPassword());

        if (userService.login(loginDto).equals("Success")) {
            return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
        }

        return new ResponseEntity<>("로그인 실패", HttpStatus.BAD_REQUEST);
    }
}
