package com.preproject.preproject.tags.mapper.mapstruct;

import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.tags.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TagMapper {
    TagResponseDto tagResponse(Tag tags);

    List<TagResponseDto> listFromDto(List<Tag> tags);
}
