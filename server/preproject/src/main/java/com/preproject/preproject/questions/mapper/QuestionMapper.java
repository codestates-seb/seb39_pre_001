package com.preproject.preproject.questions.mapper;

import com.preproject.preproject.questions.dto.QuestionPatchDto;
import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.dto.QuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    QuestionResponseDto dtoFrom(Question question);

    Question entityFromDto(QuestionPostDto dto);

    Question entityFromDto(QuestionPatchDto dto);
}
