package com.preproject.preproject.answers.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPatchDto {
    private long answer_id;

    @NotBlank
    private String content;
}
