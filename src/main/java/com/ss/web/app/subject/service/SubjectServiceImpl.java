package com.ss.web.app.subject.service;

import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;
import com.ss.web.app.utils.Repository;
import com.ss.web.app.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends ServiceImpl<Subject> {

    public SubjectServiceImpl(Repository<Subject> repository) {
        super(repository);
    }
}
