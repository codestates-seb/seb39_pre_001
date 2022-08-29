package com.preproject.preproject.questions.entity;

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
public class QuestionDislike {

    //todo : user
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionDislikeId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;
}