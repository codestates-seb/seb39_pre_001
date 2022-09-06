package com.preproject.preproject.jpa;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.questions.repository.QuestionRepository;
import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.tags.repository.TagQuestionRepository;
import com.preproject.preproject.tags.repository.TagRepository;
import com.preproject.preproject.tags.service.TagService;
import com.preproject.preproject.users.entity.Users;
import com.preproject.preproject.users.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class TagQuestionRepositoryTest {

    @Autowired
    private TagQuestionRepository tagQuestionRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository usersRepository;

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
    }


    @DisplayName("tagQuestion")
    @Test
    public void givenTagName_thenTagQuestionReturned() {

        Tag tag1 = Tag.builder().name("java").build();
        Tag tag2 = Tag.builder().name("react").build();

        Question question = questionRepository.findById(1L).orElseThrow();

        TagQuestion tagQuestion = TagQuestion.of(question, tag1);
        TagQuestion tagQuestion1 = TagQuestion.of(question, tag2);

        TagQuestion entity = tagQuestionRepository.save(tagQuestion);
        TagQuestion entity2 = tagQuestionRepository.save(tagQuestion1);

        TagQuestion tagQuestion2 = tagQuestionRepository.findByTagName(tag1.getName(), 1L).orElseThrow();
        TagQuestion tagQuestion3 = tagQuestionRepository.findByTagName(tag2.getName(), 1L).orElseThrow();

//        System.out.println(tagQuestion2.getTagQuestionId());
//        System.out.println(tagQuestion2.getQuestion().getQuestionId());
//        System.out.println(tagQuestion2.getTag().getTagId());
//        System.out.println(tagQuestion2.getTag().getName());
//        System.out.println(tagQuestion3.getTagQuestionId());
//        System.out.println(tagQuestion3.getQuestion().getQuestionId());
//        System.out.println(tagQuestion3.getTag().getTagId());
//        System.out.println(tagQuestion3.getTag().getName());
        System.out.println(tagQuestion2.getQuestion().getTags());
        System.out.println(tagQuestion2.getQuestion().getTagQuestionList().size());

        assertThat(entity).isEqualTo(tagQuestion2);



    }
}

