package com.preproject.preproject.answers.mapper;

import com.preproject.preproject.answers.dto.AnswerPatchDto;
import com.preproject.preproject.answers.dto.AnswerResponseDto;
import com.preproject.preproject.answers.dto.AnswersPostDto;
import com.preproject.preproject.answers.entity.Answers;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public class AnswerMapper {
    public Answers answerPost(AnswersPostDto answersPostDto) {
        Answers answers = new Answers();

        answers.setContent(answersPostDto.getContent());

        return answers;
    }

    public Answers answerPatch(AnswerPatchDto answerPatchDto){
        Answers answers = new Answers();
        answers.setAnswer_id(answerPatchDto.getAnswer_id());
        answers.setContent(answerPatchDto.getContent());

        return answers;
    }

    public AnswerResponseDto answerResponse(Answers answers){
        long answerId = answers.getAnswer_id();
        String content = answers.getContent();

        return new AnswerResponseDto(answerId, content);
    }
}
