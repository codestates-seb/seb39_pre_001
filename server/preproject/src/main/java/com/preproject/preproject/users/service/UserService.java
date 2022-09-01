package com.preproject.preproject.users.service;

import com.preproject.preproject.users.dto.UserLoginDto;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(Users users) {

        return userRepository.save(users);
    }

    public Users findUserCheck(long userId) {
        Optional<Users> optionalUsers
                = userRepository.findById(userId);

        Users findUser = optionalUsers.orElseThrow(() ->
                new RuntimeException("유저가 없습니다."));

        return findUser;
    }


    public String login(UserLoginDto userLoginDto) {

        Optional<Users> user = userRepository.findByEmail(userLoginDto.getEmail());

        user.orElseThrow(() -> new NoSuchElementException("존재하는 이메일이 없습니다."));

        log.info("db password : {} , input password : {} ", user.get().getPassword(), userLoginDto.getPassword());

        if (user.get().getPassword().equals(userLoginDto.getPassword())) {
            return "Success";
        }

        return "Failed";

    }
}
