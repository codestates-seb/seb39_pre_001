package com.preproject.preproject.index.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    public ResponseEntity index() {

        return new ResponseEntity<>("메인화면입니다.", HttpStatus.OK);
    }

    @GetMapping("/abouts")
    public ResponseEntity about() {

        return new ResponseEntity<>("Abouts 화면입니다", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity product() {

        return new ResponseEntity<>("products 화면입니다.", HttpStatus.OK);
    }

    @GetMapping("/forTeams")
    public ResponseEntity forTeam() {

        return new ResponseEntity<>("forTeams 화면입니다", HttpStatus.OK);
    }

}
