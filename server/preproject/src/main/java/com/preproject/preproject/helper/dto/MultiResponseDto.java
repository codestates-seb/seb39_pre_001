package com.preproject.preproject.helper.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class MultiResponseDto<T> {

    private final List<T> data;

    private final PageInfo pageInfo;

    public MultiResponseDto(List<T> data, Page<T> page) {
        this.data = data;
        this.pageInfo =
                PageInfo.builder()
                        .page(page.getNumber() + 1)
                        .size(page.getSize())
                        .totalElements(page.getTotalElements())
                        .totalPages(page.getTotalPages())
                        .build();
    }
}
