package com.jfecm.accounts.app.controller;

import com.jfecm.accounts.app.exception.ListIsEmptyException;
import com.jfecm.accounts.app.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.List;

@MappedSuperclass
@Slf4j
public abstract class BaseController<T, I extends Number, D> implements IBaseController<I, D> {
    protected BaseService<T, I, D> service;

    protected BaseController(BaseService<T, I, D> service) {
        this.service = service;
    }

    @GetMapping("")
    @Transient
    @Override
    public ResponseEntity<List<D>> getAll() {
        List<D> all = service.findAll();
        if (all.isEmpty()) {
            throw new ListIsEmptyException("Currently this resource is empty.");
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/paged")
    @Override
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {
        Page<D> all = service.findAll(pageable);
        if (all.isEmpty()) {
            throw new ListIsEmptyException("Currently this resource is empty.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(all);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<D> getOne(@PathVariable I id) {
        D byId = service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }

    @PostMapping("")
    @Override
    public ResponseEntity<D> save(@RequestBody D entity) {
        D save = service.save(entity);
        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<D> update(@PathVariable I id, @RequestBody D entity) {
        D update = service.update(id, entity);
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Object> delete(@PathVariable I id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
