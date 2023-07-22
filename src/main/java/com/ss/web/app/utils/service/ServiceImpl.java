package com.ss.web.app.utils.service;

import com.ss.web.app.utils.Repository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
@Service
public class ServiceImpl<T> implements IService<T> {
    @Autowired
    private Repository<T> repo;
    public ServiceImpl(Repository<T> repository) {
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
    public T[] findAll() {
        return repo.findAll();
    }
}
