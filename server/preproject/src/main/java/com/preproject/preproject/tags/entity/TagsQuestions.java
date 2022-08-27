package com.preproject.preproject.tags.entity;

import com.preproject.preproject.questions.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TagsQuestions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagsQuestionsId;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "TAGS_ID")
    private Tags tag;
}