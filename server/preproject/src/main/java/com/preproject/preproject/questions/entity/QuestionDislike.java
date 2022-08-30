package com.preproject.preproject.questions.entity;

import com.preproject.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "QUESTIONS_DISLIKES")
@Entity
public class QuestionDislike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionDislikeId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users user;
}