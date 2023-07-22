package com.ss.web.app.utils;

import java.util.List;

public interface Repository<T> {
    T save(T value);

    T[] findAll();

    T edit(Long id, T newValue);

    T delete(Long id);

    T get(Long id);
}
