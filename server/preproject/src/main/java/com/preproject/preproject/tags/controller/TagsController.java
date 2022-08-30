package com.preproject.preproject.tags.controller;


import com.preproject.preproject.tags.dto.TagResponseDto;
import com.preproject.preproject.tags.entity.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagsController {


    @GetMapping
    public ResponseEntity getTags() {

//        List<Tags> tags = List.of(
//                new Tags(1, "JAVA"),
//                new Tags(2, "JAVA SCRIPT"),
//                new Tags(3, "REACT"),
//                new Tags(4, "SPRING BOOT")
//        );

        TagResponseDto tags = new TagResponseDto(1L, "JAVA");

        return new ResponseEntity<>(tags, HttpStatus.OK);
    }
}
