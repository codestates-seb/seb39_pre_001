package com.preproject.preproject.answers.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Builder
public class AnswerResponseDto {
    private long answerId;
    private String content;
}
