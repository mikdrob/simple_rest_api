package com.example.practice.controller;

import com.example.practice.repository.BaseRepository;
import com.example.practice.service.BaseEntity;
import com.example.practice.service.BaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseController<TEntity extends BaseEntity<TEntity>>{

    private final BaseService<TEntity> service;

    public BaseController(BaseRepository<TEntity> repository) {
        this.service = new BaseService<TEntity>(repository) {
        };
    }
    @GetMapping
    public List<TEntity> getPerson() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<TEntity> postPerson(@Valid @RequestBody TEntity entity) {
        return ResponseEntity.ok(service.Add(entity));
    }
}
