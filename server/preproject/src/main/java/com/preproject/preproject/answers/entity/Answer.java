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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long answerId;

    @Column(nullable = false)
    private String content;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private Users user;

    public void addQuestionAndUser(Question question, Users user) {
        addQuestion(question);
        addUsers(user);
    }

    private void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getAnswers().contains(this)) {
            this.question.getAnswers().add(this);
        }
    }

    private void addUsers(Users user) {
        this.user = user;
        if (!this.user.getAnswers().contains(this)) {
            this.user.getAnswers().add(this);
        }
    }
}
