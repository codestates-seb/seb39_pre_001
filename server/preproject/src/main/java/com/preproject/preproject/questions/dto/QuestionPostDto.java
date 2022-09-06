package com.preproject.preproject.questions.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
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