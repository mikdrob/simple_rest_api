package com.example.practice.repository;

import com.example.practice.service.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<TEntity extends BaseEntity<TEntity>> extends JpaRepository<TEntity, Long> {

}