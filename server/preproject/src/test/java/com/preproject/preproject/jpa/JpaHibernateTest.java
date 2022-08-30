package com.preproject.preproject.jpa;

import com.preproject.preproject.questions.entity.Question;
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

@DataJpaTest
public class JpaHibernateTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UsersRepository usersRepository;

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

        question1.addUser(user1);

        questionRepository.save(question1);
    }


    @DisplayName("QuestionService.like")
    @Test
    public void cascadeInNtoMBidirectionalMappingTest() {
        Question entity = questionRepository.findById(1L).orElseThrow();
        System.out.println(entity.getUser() == user);
        System.out.println(entity);
    }

}
