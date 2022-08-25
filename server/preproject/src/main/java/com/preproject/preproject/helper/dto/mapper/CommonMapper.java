package com.preproject.preproject.helper.dto.mapper;

public interface CommonMapper<E, D> {

    E entityFromDto(D dto);

    D dtoFromEntity(E entity);
}
