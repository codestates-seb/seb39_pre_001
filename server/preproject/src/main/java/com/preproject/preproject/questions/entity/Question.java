package com.preproject.preproject.questions.entity;

import com.preproject.preproject.audit.Auditing;
import com.preproject.preproject.tags.entity.Tags;
import com.preproject.preproject.tags.entity.TagsQuestions;
import com.preproject.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Question extends Auditing {

    //todo: mapping to user, tags

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "question")
    private List<QuestionLike> questionLikes = new ArrayList<>();

    @OneToMany(mappedBy = "question")
    private List<QuestionDislike> questionDislikes = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "USERS_ID")
    private Users user;

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<TagsQuestions> tagsQuestions = new ArrayList<>();

}