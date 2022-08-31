package com.preproject.preproject.answers.dto;

import com.preproject.preproject.users.dto.UsersResponseDto;
import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
public class AnswerResponseDto {
    private long answerId;
    private String content;
    private UsersResponseDto user;
}
