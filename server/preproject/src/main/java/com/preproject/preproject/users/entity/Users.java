package com.preproject.preproject.users.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    private long id;
    private String display_name;
    private String password;
    private String email;
    private LocalDateTime regdate = LocalDateTime.now();
}
