package com.jfecm.accounts.app.controller;

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

    public BaseController(BaseService<T, I, D> service) {
        this.service = service;
    }

    @GetMapping("")
    @Transient
    @Override
    public ResponseEntity<List<D>> getAll() {
        List<D> all = service.findAll();
        if (all.isEmpty()) {
            throw new RuntimeException("No element found while hitting getAll");
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/paged")
    @Override
    public ResponseEntity<Page<D>> getAll(Pageable pageable) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<D> getOne(@PathVariable I id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    @Override
    public ResponseEntity<D> save(@RequestBody D entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<D> update(@PathVariable I id, @RequestBody D entity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable I id) {
        try {
            service.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
