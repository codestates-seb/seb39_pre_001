package com.preproject.preproject.questions.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class QuestionDecoratorMapper implements QuestionMapper{

    @Autowired
    @Qualifier("delegate")
    private QuestionMapper delegate;
}
