package com.preproject.preproject.answers.repository;

import com.preproject.preproject.answers.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
