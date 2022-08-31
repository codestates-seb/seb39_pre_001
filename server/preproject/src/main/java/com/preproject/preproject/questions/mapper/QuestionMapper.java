package com.preproject.preproject.questions.mapper;

import com.preproject.preproject.dto.PageInfo;
import com.preproject.preproject.questions.dto.QuestionPatchDto;
import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.dto.QuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.tags.entity.TagQuestion;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring")
//@DecoratedWith(QuestionDecoratorMapper.class)
public interface QuestionMapper {

    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "likes", source = "likeCount")
    @Mapping(target = "user.userId", source = "user.id")
    QuestionResponseDto dtoFrom(Question question);

    List<QuestionResponseDto> listDtoFromEntities(List<Question> questions);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "tagQuestionList", source = "tags")
    Question entityFromDto(QuestionPostDto dto);

    List<TagQuestion> tagQuestionListFromTags(List<String> tags);

    @Mapping(target = "tag.name", source = "tag")
    TagQuestion tagQuestionFromTag(String tag);

    Question entityFromDto(QuestionPatchDto dto);

    void updateEntityFromSource(@MappingTarget Question question, Question source);


}
