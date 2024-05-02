package com.arianit.maturabe.mapper;

public interface GenericMapper<E, D, R>{

    D toDto(E entity);

    E toEntity(R request);
}
