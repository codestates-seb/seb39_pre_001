package com.preproject.preproject.answers.controller;

import com.preproject.preproject.answers.dto.AnswerPatchDto;
import com.preproject.preproject.answers.dto.AnswerPostDto;
import com.preproject.preproject.answers.dto.AnswerResponseDto;
import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.answers.mapper.mapstruct.AnswerMapper;
import com.preproject.preproject.answers.service.AnswerService;
import com.preproject.preproject.dto.SingleResponseDto;
import com.preproject.preproject.users.entity.Users;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class AnswerController {
    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper) {
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping("/{question-id}/answer")
    public ResponseEntity postAnswer(@RequestBody AnswerPostDto answersPostDto,
                                     @PathVariable("question-id") long questionId,
                                     @AuthenticationPrincipal Users users) {
        answersPostDto.setUserId(users.getId());
        answersPostDto.setQuestionId(questionId);

        Answer answers = answerMapper.answerPost(answersPostDto);
        Answer created = answerService.createAnswer(answers);
        AnswerResponseDto response = answerMapper.answerResponse(created);


        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}/answer/{answer-id}")
    public ResponseEntity PatchAnswer(@PathVariable("answer-id") long answerId,
                                      @RequestBody AnswerPatchDto answerPatchDto,
                                      @AuthenticationPrincipal Users users) {
        answerPatchDto.setAnswerId(answerId);
        answerPatchDto.setUserId(users.getId());

        System.out.println("AnswerPatchDto.getID : " + answerPatchDto.getUserId());
        System.out.println("users.getID : " + users.getId());

        Answer answer = answerMapper.answerPatch(answerPatchDto);
        Answer response = answerService.updateAnswer(answer);

//        response.checkAnswerWriter(users.getId());

        return new ResponseEntity<>(new SingleResponseDto<>(answerMapper.answerResponse(response)), HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}/answer/{answer-id}")
    public ResponseEntity deleteAnswer(
            @PathVariable("answer-id") long answerId,
            @PathVariable("question-id") long questionId,
            @AuthenticationPrincipal Users users) {
        long userId = users.getId();

        answerService.deleteAnswer(questionId, answerId, userId);

        return new ResponseEntity<>(new SingleResponseDto<>("답글이 삭제되었습니다"), HttpStatus.NO_CONTENT);
    }
}
