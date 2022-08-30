package com.preproject.preproject.questions.entity;

import com.preproject.preproject.users.entity.Users;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "QUESTIONS_LIKES")
@Entity
public class QuestionLike {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionLikeId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users user;

    public void addQuestion(Question question) {
        this.question = question;
        if (!this.getQuestion().getQuestionLikes().contains(this)) {
            this.getQuestion().getQuestionLikes().add(this);
        }
    }

    public void addUser(Users user) {
        this.user = user;
        if (!this.getUser().getQuestionLikes().contains(this)) {
            this.getUser().getQuestionLikes().add(this);
        }
    }

    @Builder
    public static QuestionLike of(Question question, Users user) {
        QuestionLike questionLike = new QuestionLike();
        questionLike.addQuestion(question);
        questionLike.addUser(user);
        return questionLike;
    }
}