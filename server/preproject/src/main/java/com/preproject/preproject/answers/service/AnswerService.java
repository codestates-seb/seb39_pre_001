package com.preproject.preproject.answers.service;

import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.answers.repository.AnswerRepository;
import com.preproject.preproject.exception.BusinessLogicException;
import com.preproject.preproject.exception.BusinessRuntimeException;
import com.preproject.preproject.exception.ExceptionCode;
import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.repository.QuestionRepository;
import com.preproject.preproject.questions.service.QuestionService;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final UserService userService;

    private final QuestionService questionService;
    private final QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, UserService userService,
                         QuestionService questionService, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.userService = userService;
        this.questionService = questionService;
        this.questionRepository = questionRepository;
    }

    public Answer createAnswer(Answer answer) {

        //회원이 존재하는지 check 후 회원을 users 에 저장
        Users users = userService.findUserCheck(answer.getUser().getId());
        Question question = questionService.getQuestion(answer.getQuestion().getQuestionId());

        if (users.alreadyAnswered(question)) {
            throw new BusinessLogicException(ExceptionCode.ALREADY_ANSWERED);
        }

        question.setAnswerCount(question.getAnswerCount() + 1);

        answer.addQuestionAndUser(question, users);

        return answerRepository.save(answer);
    }

    public Answer updateAnswer(Answer answer) {

        Answer findAnswer = findVerifiedAnswer(answer.getAnswerId());

        findAnswer.checkAnswerWriter(answer.getUser().getId());

        Optional.ofNullable(answer.getContent()).ifPresent(content -> findAnswer.setContent(content));

        return answerRepository.save(findAnswer);
    }

    public void deleteAnswer(long questionId, long answerId, long userId) {
        Answer findAnswer = findVerifiedAnswer(answerId);
        findAnswer.checkAnswerWriterForDelete(userId);
        Question findQuestion = questionService.getQuestion(questionId);

        if (!findAnswer.hasEqual(findQuestion)) {
            throw new BusinessLogicException(ExceptionCode.ANSWER_QUESTION_NOT_MATCHED);
        }

        findQuestion.setAnswerCount(findQuestion.getAnswers().size() - 1);
        findQuestion.getAnswers().remove(findAnswer);

        questionRepository.save(findQuestion);


//        answerRepository.delete(findAnswer);


    }

    public List<Answer> getAnswersByuserId(long userid) {
        return answerRepository.findAll(userid);
    }

    public Answer findVerifiedAnswer(long answerId) {
        Optional<Answer> optionalAnswer =
                answerRepository.findById(answerId);

        Answer findAnswer = optionalAnswer.orElseThrow(() ->
//                new RuntimeException("답변을 찾을수 없습니다."));
                new BusinessLogicException(ExceptionCode.ANSWER_NOT_FOUND));

        return findAnswer;
    }
}
