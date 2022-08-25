package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.entity.QuestionLike;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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
                .title("stub : get")
                .description("what is dinner?")
                .build();
    }

    @Override
    public Question postQuestion(Question question) {
        return Question
                .builder()
                .questionId(1L)
                .title("stub : post")
                .description("what is lunch?")
                .build();
    }

    @Override
    public Question updateQuestion(Question question) {
        return Question
                .builder()
                .questionId(question.getQuestionId())
                .title("stub : update")
                .description("what is breakfast?")
                .build();
    }

    @Override
    public void like(long questionId, long userId) {

        Question foundQuestion = Question.builder().questionId(questionId).build();

        QuestionLike
                .builder()
                .questionLikeId(1L)
                .question(foundQuestion)
                .build();
    }

    @Override
    public void dislike(long questionId, long userId) {

    }
}
