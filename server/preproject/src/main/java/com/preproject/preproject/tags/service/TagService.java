package com.preproject.preproject.tags.service;

import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> findTags() {

//        List<Tag> tags = List.of(
//                new Tag(1, "JAVA", null),
//                new Tag(2, "JAVASCRIPT",null),
//                new Tag(3, "REACT",null),
//                new Tag(4, "SPRING BOOT",null)
//        );

        List<Tag> tags = tagRepository.findAll();

        return tags;

    }
}
