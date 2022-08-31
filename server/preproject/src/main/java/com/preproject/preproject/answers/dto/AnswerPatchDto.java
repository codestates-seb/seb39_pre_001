package com.preproject.preproject.answers.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPatchDto {

    private long answerId;
    @NotBlank
    private String content;
}
