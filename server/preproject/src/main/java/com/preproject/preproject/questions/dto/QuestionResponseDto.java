package com.preproject.preproject.questions.dto;

import com.preproject.preproject.answers.dto.AnswerResponseDto;
import com.preproject.preproject.tags.dto.TagResponseDto;
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
public class QuestionResponseDto {

    //todo: likes count

    private Long questionId;
    private String title;
    private String description;

    private UsersResponseDto user;

    @Builder.Default
    private List<String> tags = new ArrayList<>();

    private Long likes;
    private Long dislikes;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Builder.Default
    private List<AnswerResponseDto> answers = new ArrayList<>();
}