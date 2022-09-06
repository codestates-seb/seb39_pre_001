package com.preproject.preproject.answers.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPatchDto {

    @Positive
    private long userId;

    private long answerId;
    @NotBlank
    private String content;
}
