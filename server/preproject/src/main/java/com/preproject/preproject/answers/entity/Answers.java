package com.preproject.preproject.answers.entity;

import com.preproject.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Answers {
    private long answer_id;
    private String content;
    //todo: question entity 와 매핑 필요

    //todo: users entity 매핑 필요
    private Users users;
}
