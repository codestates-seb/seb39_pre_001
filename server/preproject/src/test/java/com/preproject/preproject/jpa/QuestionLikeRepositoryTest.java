package com.preproject.preproject.jpa;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.entity.QuestionDislike;
import com.preproject.preproject.questions.entity.QuestionLike;
import com.preproject.preproject.questions.repository.QuestionDislikeRepository;
import com.preproject.preproject.questions.repository.QuestionLikeRepository;
import com.preproject.preproject.questions.repository.QuestionRepository;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class QuestionLikeRepositoryTest {

    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionLikeRepository questionLikeRepository;

    @Autowired
    private QuestionDislikeRepository questionDislikeRepository;

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
        System.out.println(saved1 == user1);

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

//        QuestionLike questionLike =
//                QuestionLike.builder()
//                        .question(found)
//                        .user(saved1)
//                        .build();
//
//        questionLike.setQuestionLikeId(1L);
//
//        questionLikeRepository.save(questionLike);

        QuestionDislike questionDislike =
                QuestionDislike.builder()
                        .question(found)
                        .user(saved1)
                        .build();

        questionDislike.setQuestionDislikeId(1L);

        questionDislikeRepository.save(questionDislike);

    }

    @Test
    public void givenUserId_whenAlreadyDislikedByInvoked_thenTrueReturned() {


        Question found = questionRepository.findById(1L).orElseThrow();
        Users user = usersRepository.findById(1L).orElseThrow();

//        Throwable exception = assertThrows(RuntimeException.class, ()->);


        assertThat(found.alreadyDislikedBy(user)).isTrue();
    }


}