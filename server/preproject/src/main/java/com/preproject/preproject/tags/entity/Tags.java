package com.preproject.preproject.tags.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tags {
    @Id
    private long tags_id;

    private String name;


    //TODO questions entity 와 매핑 필요
}
