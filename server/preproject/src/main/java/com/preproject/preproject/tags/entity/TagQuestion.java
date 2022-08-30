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
@Table(name = "TAGS_QUESTIONS")
@Entity
public class TagQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagQuestionId;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "TAG_ID")
    private Tag tag;
}