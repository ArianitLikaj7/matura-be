package com.arianit.maturabe.mapper;

public interface UpdateGenericMapper <E, D, R, U> extends GenericMapper<E, D, R>{

    void toEntity(U updateRequest, E entity);
}
