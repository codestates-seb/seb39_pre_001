package com.preproject.preproject.tags.service;

import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.entity.TagQuestion;
import com.preproject.preproject.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class TagService {

    private final TagRepository tagRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Tag findOrCreateTag(String name) {
        return tagRepository
                .findByName(name)
                .orElse(
                        Tag.builder().name(name).build()
                );
    }
}
