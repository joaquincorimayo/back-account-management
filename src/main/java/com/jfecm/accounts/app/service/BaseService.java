package com.jfecm.accounts.app.service;

import com.jfecm.accounts.app.repository.BaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@MappedSuperclass
@Slf4j
public abstract class BaseService<T, I extends Number, D> implements IBaseService<T, I, D> {
    protected BaseRepository<T, I> repository;

    public BaseService(BaseRepository<T, I> repository) {
        this.repository = repository;
    }

    @Override
    public List<D> findAll() {
        return repository.findAll().stream().map(this::entityToDTO).collect(Collectors.toList());
    }

    @Override
    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(this::entityToDTO);
    }

    @Override
    public D findById(I id) {
        return entityToDTO(repository.findById(id).get());
    }

    @Override
    public D save(D entity) {
        return entityToDTO(repository.save(dtoToEntity(entity)));
    }

    @Override
    public D update(I id, D entity) {
        Optional<T> byId = repository.findById(id);
        T t = dtoToEntityUpdate(byId.get(), entity);
        return entityToDTO(repository.save(t));
    }

    @Override
    public void delete(I id) {
        repository.deleteById(id);
    }
}