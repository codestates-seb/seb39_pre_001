package com.preproject.preproject.answers.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPatchDto {
    private long answer_id;
    private String content;
}
