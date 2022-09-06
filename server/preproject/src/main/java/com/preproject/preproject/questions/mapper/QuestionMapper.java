package com.preproject.preproject.questions.mapper;

import com.preproject.preproject.answers.mapper.mapstruct.AnswerMapper;
import com.preproject.preproject.questions.dto.MultiQuestionResponseDto;
import com.preproject.preproject.questions.dto.QuestionPatchDto;
import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.dto.SingleQuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.tags.entity.TagQuestion;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        uses = AnswerMapper.class
)
//@DecoratedWith(QuestionDecoratorMapper.class)
public interface QuestionMapper {

    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "likes", source = "likeCount")
    @Mapping(target = "dislikes", source = "dislikeCount")
    @Mapping(target = "user.userId", source = "user.id")
    SingleQuestionResponseDto dtoFrom(Question question);

    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "likes", source = "likeCount")
    @Mapping(target = "dislikes", source = "dislikeCount")
    @Mapping(target = "answers", source = "answerCount")
    MultiQuestionResponseDto toMultiQuestionResponseDtoFrom(Question question);


    List<MultiQuestionResponseDto> listDtoFromEntities(List<Question> questions);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "tagQuestionList", source = "tags")
    Question entityFromDto(QuestionPostDto dto);

//    List<TagQuestion> tagQuestionListFromTags(List<String> tags);

    @Mapping(target = "tag.name", source = "tag")
    TagQuestion tagQuestionFromTag(String tag);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "tagQuestionList", source = "tags")
    Question entityFromDto(QuestionPatchDto dto);

    //    @Mapping(target = "tagQuestionList", )
    @BeanMapping(
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            ignoreByDefault = true)
    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    void updateEntityFromSource(@MappingTarget Question question, Question source);


    default List<TagQuestion> tagQuestionListFromTags(List<String> tags) {
        if (tags == null) {
            return null;
        }
        List<String> reduced = tags.stream().distinct().collect(Collectors.toList());
        List<TagQuestion> list = new ArrayList<TagQuestion>(reduced.size());
        for (String string : reduced) {
            list.add(tagQuestionFromTag(string));
        }

        return list;
    }
}
