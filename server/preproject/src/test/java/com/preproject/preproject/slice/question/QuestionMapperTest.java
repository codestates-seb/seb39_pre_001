package com.preproject.preproject.slice.question;

import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.mapper.QuestionMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class QuestionMapperTest {

    private final QuestionMapper questionMapper =
            Mappers.getMapper(QuestionMapper.class);

    @Test
    public void fromDtoToQuestionEntity() {

        QuestionPostDto postDto =
                QuestionPostDto.builder()
                        .title("test1")
                        .description("test1")
                        .userId(1L)
                        .tags(List.of("java","react","jjajang"))
                        .build();

        Question mapped =
                questionMapper.entityFromDto(postDto);

        assertThat(mapped.getTagQuestionList().get(0).getTag().getName()).isEqualTo("java");
        assertThat(mapped.getTagQuestionList().get(1).getTag().getName()).isEqualTo("react");
        assertThat(mapped.getTagQuestionList().get(2).getTag().getName()).isEqualTo("jjajang");

    }
}
