package com.preproject.preproject.tags.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tags_id;
    private String name;

    @OneToMany(mappedBy = "tag", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<TagsQuestions> tagsQuestions = new ArrayList<>();


}
