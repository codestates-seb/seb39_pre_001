package com.preproject.preproject.tags.service;

import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TagService {


    private final TagRepository tagRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Tag findOrCreateTag(String name) {
        return tagRepository
                .findByName(name)
                .orElseGet(
                        () -> Tag.builder().name(name).build()
                );
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
