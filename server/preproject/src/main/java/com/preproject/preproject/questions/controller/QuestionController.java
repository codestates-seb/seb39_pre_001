package com.preproject.preproject.questions.controller;

import com.preproject.preproject.helper.dto.MultiResponseDto;
import com.preproject.preproject.helper.dto.SingleResponseDto;
import com.preproject.preproject.questions.dto.QuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.service.QuestionService;
import com.preproject.preproject.questions.service.QuestionStubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public ResponseEntity<MultiResponseDto<QuestionResponseDto>> getQuestions(
            @RequestParam(name = "tab", required = false) String tab,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page) {

        return null;
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<SingleResponseDto<QuestionResponseDto>> getQuestion(
            @PathVariable long questionId) {

        Question foundQuestion = questionService.getQuestion(questionId);

        //todo : mapstruct
        return new ResponseEntity<>(new SingleResponseDto<>(QuestionResponseDto.builder().build()), HttpStatus.OK);
    }

}
