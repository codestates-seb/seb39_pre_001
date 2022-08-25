package com.preproject.preproject.helper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
@Builder
public class PageInfo {

    private int page;
    private int size;
    private long totalElements;
    private int totalPages;

}
