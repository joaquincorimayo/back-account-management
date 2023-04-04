package com.jfecm.accounts.app.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

public interface BaseMapper<T, D> {
    D map(T t);

    T unMap(D dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    T unMap(@MappingTarget T t, D dto);

    List<D> map(List<T> t);

    Set<D> map(Set<T> t);

    List<T> unMap(List<D> dto);
}
