package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Profile("dev")
@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Page<Question> getQuestions(Pageable pageable) {

        return questionRepository.findAll(pageable);
    }

    @Override
    public Question getQuestion(long questionId) {
        return null;
    }

    @Override
    public Question postQuestion(Question question) {
        return null;
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    @Override
    public void like(long questionId, long userId) {

    }

    @Override
    public void dislike(long questionId, long userId) {

    }
}
