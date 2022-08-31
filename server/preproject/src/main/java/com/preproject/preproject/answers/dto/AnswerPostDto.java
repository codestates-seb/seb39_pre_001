package com.preproject.preproject.answers.dto;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.users.entity.Users;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AnswerPostDto {

    @Positive
    private long userId;
    @NotBlank
    private String content;

    @Positive
    private long questionId;

    public Users getUser() {
        Users users = new Users();
        users.setId(userId);
        return users;
    }

    public Question getQuestion() {
        Question question = new Question();
        question.setQuestionId(questionId);
        return question;
    }
}
