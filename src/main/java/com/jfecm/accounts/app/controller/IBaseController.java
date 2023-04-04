package com.jfecm.accounts.app.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IBaseController<I extends Number, D> {
    ResponseEntity<List<D>> getAll();

    ResponseEntity<Page<D>> getAll(Pageable pageable);

    ResponseEntity<D> getOne(@PathVariable I id);

    ResponseEntity<D> save(@RequestBody D entity);

    ResponseEntity<D> update(@PathVariable I id, @RequestBody D entity);

    ResponseEntity<?> delete(@PathVariable I id);
}
