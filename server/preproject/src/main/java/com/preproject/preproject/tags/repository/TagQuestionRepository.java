package com.preproject.preproject.tags.repository;

import com.preproject.preproject.tags.entity.TagQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TagQuestionRepository extends JpaRepository<TagQuestion, Long> {

    @Query("SELECT tq FROM TagQuestion tq JOIN tq.tag t WHERE t.name = :tag and tq.question.questionId = :questionId")
    Optional<TagQuestion> findByTagName(
            @Param("tag") String tag,
            @Param("questionId") long questionId);
}
