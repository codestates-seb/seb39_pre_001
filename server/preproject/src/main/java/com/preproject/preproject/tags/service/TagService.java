package com.preproject.preproject.tags.service;

import com.preproject.preproject.tags.entity.Tags;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    public List<Tags> findTags() {

        List<Tags> tags = List.of(
                new Tags(1, "JAVA"),
                new Tags(2, "JAVASCRIPT"),
                new Tags(3, "REACT"),
                new Tags(4, "SPRING BOOT")
        );

        return tags;

    }
}
