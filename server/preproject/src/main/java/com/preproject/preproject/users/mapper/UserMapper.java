package com.preproject.preproject.users.mapper;

import com.preproject.preproject.users.dto.UserResponseDto;
import com.preproject.preproject.users.dto.UsersPostDto;
import com.preproject.preproject.users.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Users userPost(UsersPostDto usersPostDto) {
        Users users = new Users();

        users.setDisplay_name(usersPostDto.getDisplay_name());
        users.setEmail(usersPostDto.getEmail());
        users.setPassword(usersPostDto.getPassword());

        return users;
    }

    public UserResponseDto userResponse(Users users) {
        long userId = users.getId();
        String display_name = users.getDisplay_name();
        String email = users.getEmail();
        String password = users.getPassword();

        return new UserResponseDto(userId, display_name, email, password);
    }
}
