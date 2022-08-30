package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.entity.QuestionLike;
import com.preproject.preproject.questions.repository.QuestionRepository;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Profile("dev")
@RequiredArgsConstructor
@Service
public class QuestionServiceImpl2 implements QuestionService{

    private final QuestionRepository questionRepository;
    private final UsersService usersService;

    @Override
    public Page<Question> getQuestions(Pageable pageable) {
        return null;
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
        Users user = usersService.getUserById(userId);
        Question question = questionRepository.findById(questionId).orElseThrow();

        if (question.alreadyLikedBy(user)) {
            throw new RuntimeException("you have already liked this question.");
        }

        QuestionLike questionLike =
                QuestionLike.builder()
                        .question(question)
                        .user(user)
                        .build();

        questionRepository.save(question);
    }

    @Override
    public void dislike(long questionId, long userId) {

    }

}

