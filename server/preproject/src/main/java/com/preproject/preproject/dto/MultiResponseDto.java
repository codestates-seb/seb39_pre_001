package com.preproject.preproject.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MultiResponseDto<T> {

    private final List<T> data;

    private final PageInfo pageInfo;

    public MultiResponseDto(List<T> contents, PageInfo pageInfo) {
        this.data = contents;
        this.pageInfo = pageInfo;
    }
}
