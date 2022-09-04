package com.preproject.preproject.answers.mapper.mapstruct;

import com.preproject.preproject.answers.dto.AnswerPatchDto;
import com.preproject.preproject.answers.dto.AnswerPostDto;
import com.preproject.preproject.answers.dto.AnswerResponseDto;
import com.preproject.preproject.answers.entity.Answer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPost(AnswerPostDto answerPostDto);

    Answer answerPatch(AnswerPatchDto answerPatchDto);

    @Mapping(target = "user.userId", source = "user.id")
    @Mapping(target = "questionId", source = "question.questionId")
    AnswerResponseDto answerResponse(Answer answer);
}
