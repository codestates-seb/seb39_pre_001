package com.preproject.preproject.questions.entity;

import com.preproject.preproject.users.entity.Users;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "QUESTIONS_DISLIKES")
@Entity
public class QuestionDislike {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionDislikeId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users user;


    public void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getQuestionDislikes().contains(this)) {
            this.question.getQuestionDislikes().add(this);
        }
    }

    public void addUser(Users user) {
        this.user = user;
        if (!this.user.getQuestionDislikes().contains(this)) {
            this.user.getQuestionDislikes().add(this);
        }
    }

    @Builder
    public static QuestionDislike of(Question question, Users user) {
        System.out.println("i'm invoked");
        QuestionDislike questionDislike = new QuestionDislike();
        questionDislike.addQuestion(question);
        questionDislike.addUser(user);
        return questionDislike;
    }
}