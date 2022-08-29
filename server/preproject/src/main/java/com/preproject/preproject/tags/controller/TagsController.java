package com.preproject.preproject.tags.controller;


import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.tags.entity.Tags;
import com.preproject.preproject.tags.mapper.TagMapper;
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
public class TagsController {

    private final TagService tagService;
    private final TagMapper mapper;

    public TagsController(TagService tagService, TagMapper mapper) {
        this.tagService = tagService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity getTags() {

        List<Tags> tags = tagService.findTags();
        List<TagResponseDto> response = tags.stream()
                .map(tags1 -> mapper.tagResponse(tags1)).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
