package com.preproject.preproject.tags.entity;

import com.preproject.preproject.questions.entity.Question;
import com.preproject.preproject.tags.repository.TagQuestionFunction;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "TAGS_QUESTIONS")
@Entity
public class TagQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagQuestionId;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "TAG_ID")
    private Tag tag;

    public void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getTagQuestionList().contains(this)) {
            this.question.getTagQuestionList().add(this);
        }
    }

    public void addTag(Tag tag) {
        this.tag = tag;
        if (!this.tag.getTagQuestionList().contains(this)) {
            this.tag.getTagQuestionList().add(this);
        }
    }

    public static TagQuestion of(Question question, Tag tag) {
        TagQuestion tagQuestion = new TagQuestion();
        tagQuestion.addQuestion(question);
        tagQuestion.addTag(tag);
        return tagQuestion;
    }

}