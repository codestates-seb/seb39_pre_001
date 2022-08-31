package com.preproject.preproject.tags.mapper;

import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.tags.entity.Tag;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public class TagMapper {

    public TagResponseDto tagResponse(Tag tags) {
        long tagId = tags.getTagId();
        String name = tags.getName();

        return new TagResponseDto(tagId, name);
    }
}
