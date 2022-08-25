package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.entity.Question;
import org.springframework.data.domain.Page;

public interface QuestionService {

    Page<Question> getQuestions(int page, int size);

    Question getQuestion(long questionId);

    Question postQuestion(Question question);

    Question updateQuestion(Question question);

    void like(long questionId, long userId);

    void dislike(long questionId, long userId);
}
