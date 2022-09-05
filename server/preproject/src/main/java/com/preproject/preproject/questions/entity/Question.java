package com.preproject.preproject.questions.entity;

import com.preproject.preproject.answers.entity.Answer;
import com.preproject.preproject.audit.Auditing;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.users.entity.Users;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "QUESTIONS")
@Entity
@Setter
public class Question extends Auditing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Setter
    @Column(nullable = false)
    private String title;

    @Setter
    @Column(nullable = false)
    private String description;

    private int answerCount;
    private int likeCount;
    private int dislikeCount;
    private int views;

    @Builder.Default
    @Setter
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<QuestionLike> questionLikes = new ArrayList<>();

    @Builder.Default
    @Setter
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<QuestionDislike> questionDislikes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private Users user;

    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<TagQuestion> tagQuestionList = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "question", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Answer> answers = new ArrayList<>();


    public boolean alreadyLikedBy(Users user) {
        return this
                .getQuestionLikes().stream()
                .anyMatch(questionLike -> questionLike.getUser() == user);
    }

    public boolean alreadyDislikedBy(Users user) {
        return this
                .getQuestionDislikes().stream()
                .anyMatch(questionDislike -> questionDislike.getUser() == user);
    }

    public void checkWriter(long userId) {
        if (this.getUser().getId() != userId) {
            throw new RuntimeException("Only user who wrote this question can update.");
        }
    }

    public void addUser(Users user) {
        this.user = user;
        if (!this.user.getQuestions().contains(this)) {
            this.user.getQuestions().add(this);
        }
    }

    public int getLikeCount() {
        return this.questionLikes.size();
    }

    public List<String> getTags() {
        return this.tagQuestionList.stream().map(tagQuestion -> tagQuestion.getTag().getName()).collect(Collectors.toList());
    }


    public boolean taggedWith(TagQuestion tagQuestion) {
        return this.getTagQuestionList().contains(tagQuestion);
    }

    /**
     * setter method for stubbing.
     * Must only be used for testing.</br>
     *
     * @author thom-mac
     */
    public void setTagQuestionListForStub(List<TagQuestion> tagQuestionList) {
        this.tagQuestionList.addAll(tagQuestionList);
    }

    /**
     * setter method for stubbing. Must only be used for testing.
     *
     * @author thom-mac
     */
//    public void setQuestionLikes(List<QuestionLike> questionLikeList) {
//        this.questionLikes = questionLikeList;
//    }
}