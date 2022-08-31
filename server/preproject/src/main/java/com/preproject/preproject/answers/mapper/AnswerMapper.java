//package com.preproject.preproject.answers.mapper;
//
//import com.preproject.preproject.answers.dto.AnswerPatchDto;
//import com.preproject.preproject.answers.dto.AnswerResponseDto;
//import com.preproject.preproject.answers.dto.AnswerPostDto;
//import com.preproject.preproject.answers.entity.Answer;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AnswerMapper {
//    public Answer answerPost(AnswerPostDto answersPostDto) {
//        Answer answers = new Answer();
//
//        answers.setContent(answersPostDto.getContent());
//
//        return answers;
//    }
//
//    public Answer answerPatch(AnswerPatchDto answerPatchDto){
//        Answer answers = new Answer();
//        answers.setAnswerId(answerPatchDto.getAnswerId());
//        answers.setContent(answerPatchDto.getContent());
//
//        return answers;
//    }
//
////    public AnswerResponseDto answerResponse(Answer answers){
////        long answerId = answers.getAnswerId();
////        String content = answers.getContent();
////
//////        return new AnswerResponseDto(answerId, content);
////    }
//}
