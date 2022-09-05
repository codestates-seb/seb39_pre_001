package com.preproject.preproject.users.controller;


import com.preproject.preproject.config.security.JwtTokenProvider;
import com.preproject.preproject.exception.BusinessLogicException;
import com.preproject.preproject.exception.ExceptionCode;
import com.preproject.preproject.users.dto.UserLoginDto;
import com.preproject.preproject.users.dto.UsersPostDto;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.mapper.UserMapper;
import com.preproject.preproject.users.repository.UserRepository;
import com.preproject.preproject.users.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;


    @PostMapping("/join")
    public ResponseEntity postUser(@RequestBody UsersPostDto usersPostDto) {
        Users users = userMapper.userPost(usersPostDto);
        users.setRoles(Collections.singleton("ROLE_USER"));

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

//        if (userService.login(loginDto).equals("Success")) {
//            return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
//        }
//
//        throw new BusinessLogicException(ExceptionCode.PASSWORD_NOT_MATCH);
        Optional<Users> user = userRepository.findByEmail(loginDto.getEmail());
        user.orElseThrow(() -> new BusinessLogicException(ExceptionCode.EMAIL_NOT_FOUND));

        if (!user.get().getPassword().equals(loginDto.getPassword())) {
            throw new BusinessLogicException(ExceptionCode.PASSWORD_NOT_MATCH);
        }

        return new ResponseEntity<>(jwtTokenProvider.createToken(user.get().getUsername(), user.get().getRoles()), HttpStatus.OK);
    }

}
