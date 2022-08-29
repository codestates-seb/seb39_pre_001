package com.preproject.preproject.users.mapper.mapstruct;

import com.preproject.preproject.users.dto.UsersResponseDto;
import com.preproject.preproject.users.dto.UsersPostDto;
import com.preproject.preproject.users.entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    Users userPost(UsersPostDto usersPostDto);

    UsersResponseDto userResponse(Users users);


}
