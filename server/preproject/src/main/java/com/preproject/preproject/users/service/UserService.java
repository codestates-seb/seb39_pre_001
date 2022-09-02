package com.preproject.preproject.users.service;

import com.preproject.preproject.exception.BusinessLogicException;
import com.preproject.preproject.exception.ExceptionCode;
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
                new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));

        return findUser;
    }


    public String login(UserLoginDto userLoginDto) {

        Optional<Users> user = userRepository.findByEmail(userLoginDto.getEmail());

        user.orElseThrow(() -> new BusinessLogicException(ExceptionCode.EMAIL_NOT_FOUND));

        log.info("db password : {} , input password : {} ", user.get().getPassword(), userLoginDto.getPassword());

        if (user.get().getPassword().equals(userLoginDto.getPassword())) {
            return "Success";
        }

        return "Failed";

    }
}
