package com.preproject.preproject.answers.service;

import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.answers.repository.AnswerRepository;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final UserService userService;

    public AnswerService(AnswerRepository answerRepository, UserService userService) {
        this.answerRepository = answerRepository;
        this.userService = userService;
    }

    public Answer createAnswer(Answer answer) {

        //회원이 존재하는지 check 후 회원을 users 에 저장
        Users users = userService.findUserCheck(answer.getUser().getId());

        answer.setUser(users);

        users.getAnswers().add(answer);

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
                new RuntimeException("답변을 찾을수 없습니다."));

        return findAnswer;
    }
}
