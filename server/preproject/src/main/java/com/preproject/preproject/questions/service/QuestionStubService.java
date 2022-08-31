package com.preproject.preproject.questions.service;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.entity.QuestionLike;
import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.users.entity.Users;
import org.springframework.context.annotation.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("local")
@Service
public class QuestionStubService implements QuestionService {

    /** stubbing method. stubbed data as following scenario.</br>
     *
     * <p>Scenario:
     * - three tags : java, react, mysql
     * - user1 : writes question1. dislike question2.
     * - user2 : wrties question2. likes question1.
     *
     * - question1: tagged with java, mysql.
     * - question2: tagged with react.
     * */
    @Override
    public Page<Question> getQuestions(Pageable pageable) {

        Users user1 =
                Users.builder()
                        .displayName("user1")
                        .id(1L)
                        .email("user1")
                        .build();
        Users user2 =
                Users.builder()
                        .displayName("user2")
                        .id(2L)
                        .email("user2")
                        .build();

        Tag tag1 =
                Tag.builder()
                        .tagId(1L)
                        .name("java")
                        .build();

        Tag tag2 =
                Tag.builder()
                        .tagId(2L)
                        .name("react")
                        .build();

        Tag tag3 =
                Tag.builder()
                        .tagId(3L)
                        .name("mysql")
                        .build();

        Question question1 =
                Question.builder()
                        .questionId(1L)
                        .title("프로젝트는 무엇인가여")
                        .description("먹는건가여")
                        .user(user1)
                        .build();

        Question question2 =
                Question.builder()
                        .questionId(2L)
                        .title("question2")
                        .description("question2")
                        .user(user2)
                        .build();

        TagQuestion tagQuestion1 =
                TagQuestion.builder()
                        .tagQuestionId(1L)
                        .tag(tag1)
                        .question(question1)
                        .build();

        TagQuestion tagQuestion2 =
                TagQuestion.builder()
                        .tagQuestionId(2L)
                        .tag(tag3)
                        .question(question1)
                        .build();

        TagQuestion tagQuestion3 =
                TagQuestion.builder()
                        .tagQuestionId(3L)
                        .tag(tag2)
                        .question(question2)
                        .build();

        QuestionLike questionLike1 =
                QuestionLike.builder()
                        .question(question2)
                        .user(user1)
                        .build();
        questionLike1.setQuestionLikeId(1L);

        QuestionLike questionLike2 =
                QuestionLike.builder()
                        .question(question1)
                        .user(user2)
                        .build();
        questionLike2.setQuestionLikeId(2L);

        question1.setTagQuestionList(List.of(tagQuestion1, tagQuestion2));
        question2.setTagQuestionList(List.of(tagQuestion3));
        question1.setQuestionLikes(List.of(questionLike2));
        question2.setQuestionLikes(List.of(questionLike1));

        List<Question> content = List.of(question1, question2,
                new Question(), new Question(), new Question(), new Question(),
                new Question(), new Question(), new Question(),new Question(),
                new Question());

        return new PageImpl<>(content, pageable, content.size());

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
                .question(foundQuestion)
                .build();
    }

    @Override
    public void dislike(long questionId, long userId) {

    }
}
