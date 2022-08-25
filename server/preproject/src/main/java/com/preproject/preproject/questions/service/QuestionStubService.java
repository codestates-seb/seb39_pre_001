package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.dto.QuestionResponseDto;
import com.preproject.preproject.questions.entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionStubService implements QuestionService {

    @Override
    public Page<Question> getQuestions(int page, int size) {
        return null;
    }

    @Override
    public Question getQuestion(long questionId) {
        return Question
                .builder()
                .questionId(questionId)
                .title("stub")
                .description("what is dinner?")
                .build();
    }
}
