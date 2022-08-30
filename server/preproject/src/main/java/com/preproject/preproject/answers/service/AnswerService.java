package com.preproject.preproject.answers.service;

import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.answers.repository.AnswerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer answer) {

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {

        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());

        Optional.ofNullable(answer.getContent()).ifPresent(content -> findAnswer.setContent(content));

        return answerRepository.save(findAnswer);
    }

    public void deleteAnswer(long answerId) {
        Answer findAnswer = findVerifiedAnswer(answerId);

        answerRepository.delete(findAnswer);

    }

    public Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer =
                answerRepository.findById(answerId);

        Answer findAnswer = optionalAnswer.orElseThrow(() ->
                new RuntimeException(String.valueOf(HttpStatus.NOT_FOUND)));

        return findAnswer;
    }
}
