package com.preproject.preproject.users.service;

import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
}
