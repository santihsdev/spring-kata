package com.ss.web.app.utils;

import com.ss.web.app.utils.service.IService;
import org.springframework.web.bind.annotation.*;

public class BaseController<T, S extends IService<T>> {
    S service;

    public BaseController(S service) {
        this.service = service;
    }

    @GetMapping
    public Object[] getAll() {
        return service.findAll();
    }

    @PostMapping
    public T create(@RequestBody T student) {
        return service.add(student);
    }

    @GetMapping("/{id}")
    public T get(@PathVariable Long id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public T updatePerson(@PathVariable Long id, @RequestBody T updatedValue) {
        return service.update(id, updatedValue);
    }

    @DeleteMapping("/{id}")
    public T delete(@PathVariable Long id) {
        return service.delete(id);
    }

}
