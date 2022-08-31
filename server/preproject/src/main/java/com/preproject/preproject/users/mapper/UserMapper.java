package com.preproject.preproject.users.mapper;

import com.preproject.preproject.users.dto.UsersResponseDto;
import com.preproject.preproject.users.dto.UsersPostDto;
import com.preproject.preproject.users.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Users userPost(UsersPostDto usersPostDto) {
        Users users = new Users();

        users.setDisplayName(usersPostDto.getDisplay_name());
        users.setEmail(usersPostDto.getEmail());
        users.setPassword(usersPostDto.getPassword());

        return users;
    }

    public UsersResponseDto userResponse(Users users) {
        long userId = users.getId();
        String display_name = users.getDisplayName();
        String email = users.getEmail();
        String password = users.getPassword();

        return new UsersResponseDto(userId, display_name);
    }
}
