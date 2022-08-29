package com.preproject.preproject.users.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    private long id;

    private String display_name;
    private String password;
    private String email;
//    private LocalDateTime regdate = LocalDateTime.now();
}
