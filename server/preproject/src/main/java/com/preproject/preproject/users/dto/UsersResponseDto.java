package com.preproject.preproject.users.dto;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class UsersResponseDto {

    private long userId;
    private String displayName;

}