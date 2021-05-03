package com.example.practice.controller;

import com.example.practice.repository.base.BaseRepository;
import com.example.practice.service.BaseEntity;
import com.example.practice.service.BaseService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

public abstract class BaseController<TEntity extends BaseEntity<TEntity>>{

    private final BaseService<TEntity> service;

    public BaseController(BaseRepository<TEntity> repository) {
        this.service = new BaseService(repository) {
        };
    }
    @GetMapping
    public ResponseEntity<List<TEntity>> GetAll() {
        return ResponseEntity.ok(service.GetAll());
    }

    @PostMapping
    public ResponseEntity<TEntity> Post(@Valid @RequestBody TEntity entity) {
        return ResponseEntity.ok(service.Add(entity));
    }
}
