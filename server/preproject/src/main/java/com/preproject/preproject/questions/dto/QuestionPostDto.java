package com.preproject.preproject.questions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionPostDto {

    //todo user, tags
    private String title;
    private String description;

    private List<String> tags;
    private long userId;

}