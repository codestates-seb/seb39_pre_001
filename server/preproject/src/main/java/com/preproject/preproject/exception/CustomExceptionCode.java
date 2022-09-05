package com.preproject.preproject.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionCode {

    USER_NOT_FOUND(800, "No User Found"),
    QUESTION_NOT_FOUND(900, "Question Not Found With Given Number"),
    QUESTION_DUPLICATED(901, "Question Already Exists"),
    QUESTION_ALREADY_LIKED(902, "You Have Already Hit Liked For This Question"),
    QUESTION_ALREADY_DISLIKED(903, "You Have Already Hit Disliked"),
    QUESTION_WRITER_NOT_MATCHED(904, "Only Who Wrote This Question Can Edit");

    private final int code;
    private final String description;

}
