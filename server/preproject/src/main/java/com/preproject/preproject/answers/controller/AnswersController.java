package com.preproject.preproject.answers.controller;

import com.preproject.preproject.answers.dto.AnswerPatchDto;
import com.preproject.preproject.answers.dto.AnswersPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/questions")
public class AnswersController {

    @PostMapping("/{question-id}/answer")
    public ResponseEntity postAnswer(//@PathVariable("question-id") long question_id,
                                     @RequestBody AnswersPostDto answersPostDto) {

        return new ResponseEntity<>(answersPostDto, HttpStatus.CREATED);
    }

    @PatchMapping("/{question-id}/answer/{answer-id}")
    public ResponseEntity PatchAnswer(@PathVariable("answer-id") long answer_id,
                                      @RequestBody AnswerPatchDto answerPatchDto) {

        answerPatchDto.setAnswer_id(answer_id);

        return new ResponseEntity<>(answerPatchDto, HttpStatus.OK);
    }

    @DeleteMapping("/{question-id}/answer/{answer-id}")
    public ResponseEntity DeleteAnswer() {

        return new ResponseEntity<>("답글이 삭제되었습니다", HttpStatus.NO_CONTENT);
    }
}
