package com.jfecm.accounts.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, I extends Number> extends JpaRepository<T, I> {
}
