package com.ss.web.app.subject.repository;

import com.ss.web.app.subject.Subject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("SubjectRepoImpl")
public class SubjectRepoImpl implements SubjectRepo {
    private final Map<Long, Subject> subjectMap;

    public SubjectRepoImpl() {
        this.subjectMap = new HashMap<>();
    }

    @Override
    public Subject save(Subject value) {
        return subjectMap.computeIfAbsent(value.getCode(), k -> value);
    }

    @Override
    public Object[] findAll() {
        return subjectMap.values().toArray();
    }

    @Override
    public Subject edit(Long id, Subject newValue) {
        return subjectMap.put(id, newValue);
    }

    @Override
    public Subject delete(Long id) {
        return subjectMap.remove(id);
    }

    @Override
    public Subject get(Long id) {
        return subjectMap.get(id);
    }
}
