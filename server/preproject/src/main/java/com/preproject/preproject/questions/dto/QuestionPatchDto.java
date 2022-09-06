package com.preproject.preproject.questions.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionPatchDto {

    @Setter
    private Long questionId;
    private String title;
    private String description;

    @Builder.Default
    private List<String> tags = new ArrayList<>();

    @Setter
    private Long userId;
}