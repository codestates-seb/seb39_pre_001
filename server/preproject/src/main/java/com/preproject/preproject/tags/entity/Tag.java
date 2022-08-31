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
@Table(name = "TAGS")
@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long tagId;

    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "tag", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<TagQuestion> tagQuestionList = new ArrayList<>();


}
