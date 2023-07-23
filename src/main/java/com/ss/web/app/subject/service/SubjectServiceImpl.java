package com.ss.web.app.subject.service;

import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;
import com.ss.web.app.subject.repository.SubjectRepo;
import com.ss.web.app.utils.Repository;
import com.ss.web.app.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends ServiceImpl<Subject, SubjectRepo> {

    public SubjectServiceImpl(@Qualifier("subjectRepoImpl") SubjectRepo repository) {
        super(repository);
    }
}
