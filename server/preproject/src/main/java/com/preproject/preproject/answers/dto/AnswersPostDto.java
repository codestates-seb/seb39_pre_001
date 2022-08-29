package com.preproject.preproject.answers.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AnswersPostDto {
    @NotBlank
    private String content;
}
