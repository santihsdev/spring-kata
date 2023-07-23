package com.ss.web.app.utils.service;

import com.ss.web.app.utils.Repository;
import org.springframework.stereotype.Service;

public class ServiceImpl<T, R extends Repository<T>> implements IService<T> {

    protected R repo;
    public ServiceImpl(R repository) {
        this.repo = repository;
    }
    @Override
    public T add(T value) {
        return repo.save(value);
    }

    @Override
    public T get(Long id) {
        return repo.get(id);
    }

    @Override
    public T update(Long id, T newValue) {
        return repo.edit(id, newValue);
    }

    @Override
    public T delete(Long id) {
        return repo.delete(id);
    }

    @Override
    public Object[] findAll() {
        return repo.findAll();
    }
}
