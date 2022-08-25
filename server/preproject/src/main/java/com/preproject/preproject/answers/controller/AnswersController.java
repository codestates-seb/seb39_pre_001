package com.preproject.preproject.answers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class AnswersController {

    @PostMapping("/{question-id}/answer")
    public ResponseEntity postAnswer() {

        return new ResponseEntity<>("Created!!", HttpStatus.CREATED);
    }
}
