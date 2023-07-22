package com.ss.web.app.utils;

import com.ss.web.app.utils.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BaseController<T> {
    IService<T> service;

    @GetMapping
    public T[] getAll() {
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
    public T delete(@PathVariable Long idStudent) {
        return service.delete(idStudent);
    }

}
