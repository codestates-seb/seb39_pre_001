package com.preproject.preproject.users.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private long userId;
    private String display_name;
    private String email;
    private String password;
}
