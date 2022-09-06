package com.preproject.preproject.users.controller;


import com.preproject.preproject.config.security.JwtTokenProvider;
import com.preproject.preproject.dto.SingleResponseDto;
import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.answers.service.AnswerService;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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

    private final BCryptPasswordEncoder passwordEncoder;

    private final AnswerService answerService;

    @PostMapping("/join")
    public ResponseEntity postUser(@RequestBody UsersPostDto usersPostDto) {
        Users users = userMapper.userPost(usersPostDto);
        users.setRoles(Collections.singletonList("ROLE_USER"));
        users.setPassword(passwordEncoder.encode(users.getPassword()));

        Users response = userService.createUser(users);

        return new ResponseEntity(new SingleResponseDto<>(userMapper.userResponse(response)), HttpStatus.CREATED);
    }

    @GetMapping("/join")
    public ResponseEntity getUser() {

        return new ResponseEntity<>("Welcome Join User", HttpStatus.OK);
    }

    //login 기능
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserLoginDto loginDto, HttpServletResponse response) {
        log.info("email = {} , password = {} ", loginDto.getEmail(), loginDto.getPassword());

//        if (userService.login(loginDto).equals("Success")) {
//            return new ResponseEntity<>("로그인 성공", HttpStatus.OK);
//        }
//
//        throw new BusinessLogicException(ExceptionCode.PASSWORD_NOT_MATCH);
        Users user = userRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.EMAIL_NOT_FOUND));

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new BusinessLogicException(ExceptionCode.PASSWORD_NOT_MATCH);
        }

        String token = jwtTokenProvider.createToken(user.getUsername(), user.getRoles(), user.getDisplayName());
        response.setHeader("X-AUTH-TOKEN",token);

//        Cookie cookie = new Cookie("X-AUTH-TOKEN", token);
//        cookie.setPath("/");
//        cookie.setHttpOnly(true);
//        cookie.setSecure(true);
//        response.addCookie(cookie);

        return new ResponseEntity<>(user.getDisplayName(), HttpStatus.OK);
    }

//    @PostMapping("/logout")
//    public void logout(HttpServletResponse response) {
//        Cookie cookie = new Cookie("X-AUTH-TOKEN", null);
//        cookie.setHttpOnly(true);
//        cookie.setSecure(false);
//        cookie.setMaxAge(0);
//        cookie.setPath("/");
//        response.addCookie(cookie);
//    }

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
