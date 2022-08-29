package com.preproject.preproject.tags.mapper;

import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.tags.entity.Tags;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {

    public TagResponseDto tagResponse(Tags tags) {
        long tagId = tags.getTags_id();
        String name = tags.getName();

        return new TagResponseDto(tagId, name);
    }
}
