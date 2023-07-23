package com.ss.web.app.utils.service;

public interface IService<T> {
    T add(T value);
    T get(Long id);
    T update(Long id, T newValue);
    T delete(Long id);
    Object[] findAll();
}
