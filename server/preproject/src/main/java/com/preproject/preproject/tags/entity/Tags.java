package com.preproject.preproject.tags.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tags {
    private long tags_id;
    private String name;


    //TODO questions entity 와 매핑 필요
}
