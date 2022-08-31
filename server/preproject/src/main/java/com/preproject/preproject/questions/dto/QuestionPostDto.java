package com.preproject.preproject.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionPostDto {
    
    private String title;
    private String description;

    @Builder.Default
    private List<String> tags = new ArrayList<>();
    private long userId;

}