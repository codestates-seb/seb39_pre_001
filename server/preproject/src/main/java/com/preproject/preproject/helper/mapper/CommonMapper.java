package com.preproject.preproject.helper.mapper;

public interface CommonMapper<E, D> {

    E entityFromDto(D dto);

    D dtoFromEntity(E entity);
}
