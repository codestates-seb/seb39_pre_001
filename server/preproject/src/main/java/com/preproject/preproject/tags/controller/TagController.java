package com.preproject.preproject.tags.controller;


import com.preproject.preproject.dto.SingleResponseDto;
import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.tags.entity.Tag;
import com.preproject.preproject.tags.mapper.mapstruct.TagMapper;
import com.preproject.preproject.tags.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;
    private final TagMapper mapper;

    public TagController(TagService tagService, TagMapper mapper) {
        this.tagService = tagService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity getTags() {

        List<Tag> tags = tagService.findTags();
        List<TagResponseDto> response = mapper.listFromDto(tags);

        return new ResponseEntity<>(new SingleResponseDto<>(response), HttpStatus.OK);
    }
}
