package com.ss.web.app.utils;

public interface Repository<T> {
    T save(T value);

    Object[] findAll();

    T edit(Long id, T newValue);

    T delete(Long id);

    T get(Long id);
}
