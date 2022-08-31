package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.entity.QuestionLike;
import com.preproject.preproject.questions.repository.QuestionLikeRepository;
import com.preproject.preproject.questions.repository.QuestionRepository;
import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.tags.service.TagService;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Slf4j
@Profile("dev")
@RequiredArgsConstructor
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionLikeRepository questionLikeRepository;
    private final UsersService usersService;

    private final TagService tagService;

    @Override
    public Page<Question> getQuestions(Pageable pageable) {

        return questionRepository.findAll(pageable);
    }

    @Override
    public Question getQuestion(long questionId) {
        return getQuestionById(questionId);
    }

    @Override
    public Question postQuestion(Question question) {
        Users user = usersService.getUserById(question.getUser().getId());

        List<TagQuestion> tagQuestionList = question.getTagQuestionList().stream()
                .map(tagQuestion -> {
                    Tag tag = tagService.findOrCreateTag(tagQuestion.getTag().getName());
                    tagQuestion.addQuestion(question);
                    tagQuestion.addTag(tag);
                    return tagQuestion;
                }).collect(Collectors.toList());

        question.addUser(user);

        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return null;
    }

    @Override
    public void like(long questionId, long userId) {
        Users user = usersService.getUserById(userId);
        Question question = getQuestionById(questionId);

        if (question.alreadyLikedBy(user)) {
            throw new RuntimeException("you have already liked this question.");
        }

        QuestionLike questionLike =
                QuestionLike.builder()
                        .question(question)
                        .user(user)
                        .build();

        questionLikeRepository.save(questionLike);
    }

    @Override
    public void dislike(long questionId, long userId) {

    }

    public Question getQuestionById(long questionId) {
        return questionRepository
                .findById(questionId)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("no data");
                });
    }


    public void verifyDuplicationById(long questionId) {
        if (questionRepository.findById(questionId).isPresent()) {
            throw new RuntimeException("duplicated");
        }
    }
}
