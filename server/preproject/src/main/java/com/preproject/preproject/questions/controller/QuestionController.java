package com.preproject.preproject.questions.controller;

import com.preproject.preproject.dto.MultiResponseDto;
import com.preproject.preproject.dto.PageInfo;
import com.preproject.preproject.dto.SingleResponseDto;
import com.preproject.preproject.questions.dto.MultiQuestionResponseDto;
import com.preproject.preproject.questions.dto.QuestionPatchDto;
import com.preproject.preproject.questions.dto.QuestionPostDto;
import com.preproject.preproject.questions.dto.SingleQuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.mapper.QuestionMapper;
import com.preproject.preproject.questions.service.QuestionService;
import com.preproject.preproject.users.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/questions")
@RestController
public class QuestionController {

    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    @GetMapping
    public ResponseEntity<MultiResponseDto<MultiQuestionResponseDto>> getQuestions(
            @RequestParam(name = "tab", required = false, defaultValue = "createdAt") String tab,
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page - 1, size, Sort.by(tab));

        Page<Question> entities = questionService.getQuestions(pageable);

        PageInfo pageInfo = PageInfo.of(entities, tab);
        List<MultiQuestionResponseDto> contents = questionMapper.listDtoFromEntities(entities.getContent());

        return new ResponseEntity<>(new MultiResponseDto<>(contents, pageInfo), HttpStatus.OK);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<SingleResponseDto<SingleQuestionResponseDto>> getQuestion(
            @PathVariable long questionId) {

        Question found = questionService.getQuestion(questionId);
        SingleQuestionResponseDto responseDto = questionMapper.dtoFrom(found);

        return new ResponseEntity<>(new SingleResponseDto<>(responseDto), HttpStatus.OK);
    }

    @PostMapping("/ask")
    public ResponseEntity<SingleResponseDto<SingleQuestionResponseDto>> postQuestion(@RequestBody QuestionPostDto questionPostDto,
                                                                                     @AuthenticationPrincipal Users users) {

        // todo: user authentication needed. Principal needed.
        questionPostDto.setUserId(users.getId());

        Question mapped = questionMapper.entityFromDto(questionPostDto);
        Question created = questionService.postQuestion(mapped);
        SingleQuestionResponseDto response = questionMapper.dtoFrom(created);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.CREATED);
    }

    @PatchMapping("/{questionId}")
    public ResponseEntity<SingleResponseDto<SingleQuestionResponseDto>> updateQuestion(
            @PathVariable long questionId, @RequestBody QuestionPatchDto patchDto,
            @AuthenticationPrincipal Users users) {

        patchDto.setUserId(users.getId());
        patchDto.setQuestionId(questionId);
        Question mapped = questionMapper.entityFromDto(patchDto);
        Question updated = questionService.updateQuestion(mapped);
        SingleQuestionResponseDto response = questionMapper.dtoFrom(updated);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }


    @PatchMapping("/{questionId}/like")
    public ResponseEntity<SingleResponseDto<String>> like(@PathVariable long questionId, long userId) {
        questionService.like(questionId, userId);
        return new ResponseEntity<>(new SingleResponseDto<>("liked"), HttpStatus.OK);
    }

    @PatchMapping("/{questionId}/dislike")
    public ResponseEntity<SingleResponseDto<String>> dislike(@PathVariable long questionId, long userId) {
        questionService.dislike(questionId, userId);
        return new ResponseEntity<>(new SingleResponseDto<>("disliked"), HttpStatus.OK);
    }


    @DeleteMapping("/{questionId}")
    public ResponseEntity<SingleResponseDto<String>> delete(
            @PathVariable long questionId,
            @AuthenticationPrincipal Users users) {

        long userId = users.getId();

        questionService.delete(questionId, userId);

        return new ResponseEntity<>(new SingleResponseDto<>("delete"), HttpStatus.OK);

    }
}
