package com.preproject.preproject.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SingleResponseDto<T> {

    private final T data;

}

