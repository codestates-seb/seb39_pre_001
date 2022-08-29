package com.preproject.preproject.answers.entity;

import com.preproject.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long answerId;

    private String content;

    //todo: question entity 와 매핑 필요?

    //todo: users entity 매핑 필요?
//    private Users users;
}
