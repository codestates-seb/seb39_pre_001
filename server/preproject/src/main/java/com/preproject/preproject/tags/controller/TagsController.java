package com.preproject.preproject.tags.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagsController {


    @GetMapping
    public ResponseEntity getTags() {

        return new ResponseEntity<>("Tags List!", HttpStatus.OK);
    }
}
