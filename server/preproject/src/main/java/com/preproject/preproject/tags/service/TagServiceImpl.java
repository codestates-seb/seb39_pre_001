package com.preproject.preproject.tags.service;

import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("dev")
@RequiredArgsConstructor
@Service
public class TagServiceImpl implements TagService{

    private final TagRepository tagRepository;

    @Override
    public Tag findOrCreateTag(String name) {
        return tagRepository
                .findByName(name)
                .orElse(
                        Tag.builder().name(name).build()
                );
    }
}
