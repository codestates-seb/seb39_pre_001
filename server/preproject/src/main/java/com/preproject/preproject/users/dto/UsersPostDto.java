package com.preproject.preproject.users.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Builder
public class UsersPostDto {
    @NotBlank
    private String display_name;
    @Email
    @NotBlank(message = "이메일은 비어있지 않아야 합니다.")
    private String email;

    @NotBlank
    private String password;
//    private LocalDateTime regdate = LocalDateTime.now();
}
