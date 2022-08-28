package com.preproject.preproject.dto;

import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MultiResponseDto<T> {

    private final List<T> data;

    private final PageInfo pageInfo;

    public MultiResponseDto(Page<T> page) {
        this.data = page.getContent();
        this.pageInfo =
                PageInfo.builder()
                        .page(page.getNumber() + 1)
                        .size(page.getSize())
                        .totalElements(page.getTotalElements())
                        .totalPages(page.getTotalPages())
                        .build();
    }
}
