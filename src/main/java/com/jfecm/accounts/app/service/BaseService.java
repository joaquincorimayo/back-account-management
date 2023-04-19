package com.jfecm.accounts.app.service;

import com.jfecm.accounts.app.exception.InternalServerErrorException;
import com.jfecm.accounts.app.exception.ResourceNotFoundException;
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
    private static final String MSG_ERROR_ID = "Not found resource with id = ";
    protected BaseRepository<T, I> repository;

    protected BaseService(BaseRepository<T, I> repository) {
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
        Optional<T> t = repository.findById(id);
        if (t.isPresent()) {
            return entityToDTO(t.get());
        }else{
            throw new ResourceNotFoundException(MSG_ERROR_ID + id);
        }
    }

    @Override
    public D save(D entity) {
        try {
            T save = repository.save(dtoToEntity(entity));
            return entityToDTO(save);
        } catch (Exception e) {
            throw new InternalServerErrorException("Error while saving this resource.");
        }
    }

    @Override
    public D update(I id, D entity) {
        Optional<T> byId = repository.findById(id);
        if (byId.isPresent()) {
            T t = dtoToEntityUpdate(byId.get(), entity);
            return entityToDTO(repository.save(t));
        }else{
            throw new ResourceNotFoundException(MSG_ERROR_ID + id);
        }
    }

    @Override
    public void delete(I id) {
        D byId = findById(id);
        if (byId == null) {
            throw new ResourceNotFoundException(MSG_ERROR_ID + id);
        }
        repository.deleteById(id);
    }
}
