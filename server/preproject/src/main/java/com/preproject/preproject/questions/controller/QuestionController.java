package com.preproject.preproject.questions.controller;

import com.preproject.preproject.helper.dto.MultiResponseDto;
import com.preproject.preproject.helper.dto.SingleResponseDto;
import com.preproject.preproject.questions.dto.QuestionPatchDto;
import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.dto.QuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.mapper.QuestionMapper;
import com.preproject.preproject.questions.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    @GetMapping
    public ResponseEntity<MultiResponseDto<QuestionResponseDto>> getQuestions(
            @RequestParam(name = "tab", required = false) String tab,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page) {

        return null;
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<SingleResponseDto<QuestionResponseDto>> getQuestion(
            @PathVariable long questionId) {

        Question found = questionService.getQuestion(questionId);
        QuestionResponseDto responseDto = questionMapper.dtoFrom(found);

        return new ResponseEntity<>(new SingleResponseDto<>(responseDto), HttpStatus.OK);
    }

    @PostMapping("/ask")
    public ResponseEntity<SingleResponseDto<QuestionResponseDto>> postQuestion(@RequestBody QuestionPostDto questionPostDto) {

        Question mapped = questionMapper.entityFromDto(questionPostDto);
        Question created = questionService.postQuestion(mapped);
        QuestionResponseDto response = questionMapper.dtoFrom(created);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{questionId}")
    public ResponseEntity<SingleResponseDto<QuestionResponseDto>> updateQuestion(
            @PathVariable long questionId, @RequestBody QuestionPatchDto patchDto) {

        patchDto.setQuestionId(questionId);
        Question mapped = questionMapper.entityFromDto(patchDto);
        Question updated = questionService.updateQuestion(mapped);
        QuestionResponseDto response = questionMapper.dtoFrom(updated);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }


    @PatchMapping("/{questionId}/like")
    public ResponseEntity like(@PathVariable long questionId, long userId) {
        //todo : check user and create
        questionService.like(questionId, userId);
        return new ResponseEntity("liked", HttpStatus.OK);
    }

    @PatchMapping("/{questionId}/dislike")
    public ResponseEntity dislike(@PathVariable long questionId, long userId) {
        questionService.dislike(questionId, userId);
        return new ResponseEntity("disliked", HttpStatus.OK);
    }
}
