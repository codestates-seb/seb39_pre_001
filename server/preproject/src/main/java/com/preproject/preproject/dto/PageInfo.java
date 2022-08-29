package com.preproject.preproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
@AllArgsConstructor
@Builder
public class PageInfo {

    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private String tab;

    public static PageInfo of(Page page, String tab) {
        return PageInfo.builder()
                .page(page.getNumber() + 1)
                .size(page.getSize())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .tab(tab)
                .build();
    }

}
