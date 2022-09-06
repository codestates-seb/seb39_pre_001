package com.preproject.preproject.answers.entity;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    @Column(nullable = false)
    private String content;

    //todo: question entity 와 매핑 필요?
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    //todo: users entity 매핑 필요?
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users user;

    public void checkAnswerWriter(long userId) {
        System.out.println("checkAnswerWriter : "+ this.getUser().getId());
        System.out.println("parameterId : " + userId);
        if (this.getUser().getId() != userId) {
            throw new RuntimeException("Only user who wrote this answer can update.");
        }
    }

    public void checkAnswerWriterForDelete(long userId) {
        System.out.println("checkAnswerWriter : "+ this.getUser().getId());
        System.out.println("parameterId : " + userId);
        if (this.getUser().getId() != userId) {
            throw new RuntimeException("Only user who wrote this answer can delete.");
        }
    }
}
