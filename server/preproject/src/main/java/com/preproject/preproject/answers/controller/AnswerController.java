package com.preproject.preproject.answers.controller;

import com.preproject.preproject.answers.dto.AnswerPatchDto;
import com.preproject.preproject.answers.dto.AnswerPostDto;
import com.preproject.preproject.answers.dto.AnswerResponseDto;
import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.answers.mapper.mapstruct.AnswerMapper;
import com.preproject.preproject.answers.service.AnswerService;
import com.preproject.preproject.dto.SingleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
                                     @PathVariable("question-id") long questionId) {
        answersPostDto.setQuestionId(questionId);

        Answer answers = answerMapper.answerPost(answersPostDto);
        Answer created = answerService.createAnswer(answers);
        AnswerResponseDto response = answerMapper.answerResponse(created);


        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}/answer/{answer-id}")
    public ResponseEntity PatchAnswer(@PathVariable("answer-id") long answerId,
                                      @RequestBody AnswerPatchDto answerPatchDto) {
        answerPatchDto.setAnswerId(answerId);
        System.out.println(answerPatchDto.getAnswerId());

        Answer response =
                answerService.updateAnswer(answerMapper.answerPatch(answerPatchDto));

        return new ResponseEntity<>(answerMapper.answerResponse(response), HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}/answer/{answer-id}")
    public ResponseEntity DeleteAnswer(@PathVariable("answer-id") long answerId) {

        answerService.deleteAnswer(answerId);

        return new ResponseEntity<>("답글이 삭제되었습니다", HttpStatus.NO_CONTENT);
    }
}
