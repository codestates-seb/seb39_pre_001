package com.preproject.preproject.tags.service;

import com.preproject.preproject.tags.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    public List<Tag> findTags() {

        List<Tag> tags = List.of(
                new Tag(1, "JAVA", null),
                new Tag(2, "JAVASCRIPT",null),
                new Tag(3, "REACT",null),
                new Tag(4, "SPRING BOOT",null)
        );

        return tags;

    }
}
