package com.preproject.preproject.questions.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionPatchDto {

    @Setter
    private long questionId;
    private String title;
    private String description;

    private List<String> tags;
}