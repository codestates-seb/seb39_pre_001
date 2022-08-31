package com.preproject.preproject.jpa;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.entity.QuestionLike;
import com.preproject.preproject.questions.repository.QuestionLikeRepository;
import com.preproject.preproject.questions.repository.QuestionRepository;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.repository.UsersRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class JpaHibernateTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private QuestionLikeRepository questionLikeRepository;

    private Users user;

    @BeforeEach
    public void populateData() {
        Users user1 =
                Users.builder()
                        .id(1L)
                        .email("user1")
                        .displayName("user1")
                        .regdate(LocalDateTime.now())
                        .build();

        Users user2 =
                Users.builder()
                        .id(2L)
                        .email("user2")
                        .displayName("user2")
                        .regdate(LocalDateTime.now())
                        .build();

        Users saved1 = usersRepository.save(user1);
        System.out.println(saved1==user1);
        user = saved1;
        usersRepository.save(user2);

        Question question1 =
                Question.builder()
                        .questionId(1L)
                        .title("question1")
                        .description("question1")
                        .build();

        question1.addUser(saved1);

        questionRepository.save(question1);

        Question found = questionRepository.findById(question1.getQuestionId()).orElseThrow();

        QuestionLike questionLike =
                QuestionLike.builder()
                        .question(found)
                        .user(saved1)
                        .build();

        questionLike.setQuestionLikeId(1L);
        questionLikeRepository.save(questionLike);

    }


    @DisplayName("QuestionService.like")
    @Test
    public void cascadeInNtoMBidirectionalMappingTest() {
        Question entity = questionRepository.findById(1L).orElseThrow();
        Users users = usersRepository.findById(1L).orElseThrow();
        System.out.println("userId who wrote this question : " + entity.getUser().getId());
        System.out.println("question Id written by user1 : " + users.getQuestions().get(0).getQuestionId());
        System.out.println(entity.getUser() == user);
        System.out.println(entity);
        System.out.println("quesitionLlikeId : " +entity.getQuestionLikes().get(0).getQuestionLikeId());
        System.out.println(entity.getQuestionLikes().get(0).getUser().getId());
        System.out.println(entity.getQuestionLikes().get(0).getQuestion().getQuestionId());
        questionLikeRepository.findAll().forEach(
                questionLike -> {System.out.println(questionLike.getQuestionLikeId());
                    System.out.println(questionLike.getQuestion().getQuestionId());
                    System.out.println(questionLike.getUser().getId());}

        );
        System.out.println(questionLikeRepository.findAll().size());

    }


}
