package com.preproject.preproject.questions.entity;

import com.preproject.preproject.audit.Auditing;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Builder.Default
    @OneToMany(mappedBy = "question")
    private List<QuestionLike> questionLikes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USERS_ID")
    private Users user;

    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<TagQuestion> tagQuestionList = new ArrayList<>();

    public List<String> getTags() {
        return this.tagQuestionList.stream().map(tagQuestion -> tagQuestion.getTag().getName()).collect(Collectors.toList());
    }


    /**
     * setter method for stubbing.
     * Must only be used for testing.</br>
     *
     * @author thom-mac
     */
    public void setTagQuestionList(List<TagQuestion> tagQuestionList) {
        this.tagQuestionList.addAll(tagQuestionList);
    }

    /**
     * setter method for stubbing. Must only be used for testing.
     *
     * @author thom-mac
     */
    public void setQuestionLikes(List<QuestionLike> questionLikeList) {
        this.questionLikes.addAll(questionLikeList);
    }
}