package com.preproject.preproject.answers.mapper.mapstruct;

import com.preproject.preproject.answers.dto.AnswerPatchDto;
import com.preproject.preproject.answers.dto.AnswerPostDto;
import com.preproject.preproject.answers.dto.AnswerResponseDto;
import com.preproject.preproject.answers.entity.Answer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    Answer answerPost(AnswerPostDto answerPostDto);

    Answer answerPatch(AnswerPatchDto answerPatchDto);

    AnswerResponseDto answerResponse(Answer answer);
}
