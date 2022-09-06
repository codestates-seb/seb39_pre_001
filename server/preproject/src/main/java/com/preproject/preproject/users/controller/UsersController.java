package com.preproject.preproject.users.controller;


import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.answers.service.AnswerService;
import com.preproject.preproject.dto.SingleResponseDto;
import com.preproject.preproject.exception.BusinessLogicException;
import com.preproject.preproject.exception.ExceptionCode;
import com.preproject.preproject.users.dto.UserLoginDto;
import com.preproject.preproject.users.dto.UsersPostDto;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.mapper.UserMapper;
import com.preproject.preproject.users.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UsersController {

    private final UserService userService;

    private final UserMapper userMapper;

    private final AnswerService answerService;

    public UsersController(UserService userService, UserMapper userMapper, AnswerService answerService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.answerService = answerService;
    }

    @PostMapping("/join")
    public ResponseEntity postUser(@RequestBody UsersPostDto usersPostDto) {
        Users users = userMapper.userPost(usersPostDto);

        Users response = userService.createUser(users);

        return new ResponseEntity(new SingleResponseDto<>(userMapper.userResponse(response)), HttpStatus.CREATED);
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

        throw new BusinessLogicException(ExceptionCode.PASSWORD_NOT_MATCH);
    }

    @GetMapping("/{user-id}/answers")
    public ResponseEntity<SingleResponseDto<String>> getAnswers(@PathVariable("user-id") long userId) {

        List<Answer> list = answerService.getAnswersByuserId(userId);
        list.forEach(x -> {
            System.out.println(x.getAnswerId());
            System.out.println(x.getContent());
        });

        return new ResponseEntity<>(new SingleResponseDto<>("test"), HttpStatus.OK);
    }
}
