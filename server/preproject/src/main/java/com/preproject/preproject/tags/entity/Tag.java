package com.preproject.preproject.tags.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    private String name;

    @OneToMany(mappedBy = "tag", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<TagQuestion> tagsQuestions = new ArrayList<>();


}
