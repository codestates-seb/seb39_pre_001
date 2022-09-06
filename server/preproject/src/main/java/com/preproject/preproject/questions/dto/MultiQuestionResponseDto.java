package com.preproject.preproject.questions.dto;

import com.preproject.preproject.answers.dto.AnswerResponseDto;
import com.preproject.preproject.users.dto.UsersResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MultiQuestionResponseDto {

    private Long questionId;
    private String title;
    private String description;

    @Builder.Default
    private List<String> tags = new ArrayList<>();

    private UsersResponseDto user;

    private Integer likes;
    private Integer dislikes;
    private Integer answers;
    private Integer views;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
