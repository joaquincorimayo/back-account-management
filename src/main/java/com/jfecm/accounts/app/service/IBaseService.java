package com.jfecm.accounts.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseService<T, I extends Number, D> {
    List<D> findAll();

    Page<D> findAll(Pageable pageable);

    D findById(I id);

    T findByIdEntity(I id);

    D save(D entity);

    D update(I id, D entity);

    void delete(I id);

    T dtoToEntity(D element);

    T dtoToEntityUpdate(T t, D d);

    D entityToDTO(T element);
}
