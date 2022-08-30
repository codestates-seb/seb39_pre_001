package com.preproject.preproject.questions.mapper;

import com.preproject.preproject.dto.PageInfo;
import com.preproject.preproject.questions.dto.QuestionPatchDto;
import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.dto.QuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
public interface QuestionMapper {

    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "likes", source = "likeCount")
    QuestionResponseDto dtoFrom(Question question);

    List<QuestionResponseDto> listDtoFromEntities(List<Question> questions);

    Question entityFromDto(QuestionPostDto dto);

    Question entityFromDto(QuestionPatchDto dto);

    void updateEntityFromSource(@MappingTarget Question question, Question source);


}
