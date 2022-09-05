package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.dto.QuestionPatchDto;
import com.preproject.preproject.questions.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {

    Page<Question> getQuestions(Pageable pageable);

    Question getQuestion(long questionId);

    Question postQuestion(Question question);

    Question updateQuestion(Question question);

    void delete(long questionId, long userId);

    void like(long questionId, long userId);

    void dislike(long questionId, long userId);
}
