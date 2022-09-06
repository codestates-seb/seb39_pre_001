package com.preproject.preproject.answers.repository;

import com.preproject.preproject.answers.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

    @Query("SELECT a FROM Answer a JOIN a.user u WHERE u.id = :userId")
    List<Answer> findAll(@Param("userId") long userId);
}
