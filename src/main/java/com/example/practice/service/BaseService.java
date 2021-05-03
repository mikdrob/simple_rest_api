package com.example.practice.service;

import com.example.practice.repository.base.BaseRepository;

import javax.transaction.Transactional;
import java.util.*;


public class BaseService<TEntity extends BaseEntity<TEntity>> {
    private final BaseRepository<TEntity> baseRepository;

    public BaseService(BaseRepository<TEntity> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<TEntity> GetAll() {
        return baseRepository.findAll();
    }

    public TEntity Add(TEntity entity) {
        return baseRepository.save(entity);
    }


}
