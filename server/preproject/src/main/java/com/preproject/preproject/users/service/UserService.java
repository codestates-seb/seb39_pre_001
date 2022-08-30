package com.preproject.preproject.users.service;

import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users createUser(Users users) {

        return userRepository.save(users);
    }
}
