package com.preproject.preproject.tags.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class TagResponseDto {
    private long tagId;
    private String name;
}
