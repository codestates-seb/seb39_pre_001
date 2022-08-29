package com.preproject.preproject.tags.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagResponseDto {

    //todo : maybe other tagged questions?

    private long tagId;
    private String name;

}