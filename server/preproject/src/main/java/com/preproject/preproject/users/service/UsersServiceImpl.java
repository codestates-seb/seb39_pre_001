package com.preproject.preproject.users.service;

import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public Users getUserById(long userId) {
        return usersRepository
                .findById(userId)
                .orElseThrow(
                        () -> {throw new NoSuchElementException("no user");}
                );
    }

}
