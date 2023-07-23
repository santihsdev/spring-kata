package com.ss.web.app.student.service;

import com.ss.web.app.student.Student;
import com.ss.web.app.student.repository.StudentRepo;
import com.ss.web.app.utils.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<Student, StudentRepo> {
  public StudentServiceImpl(@Qualifier("studentRepoImpl") StudentRepo repository) {
    super(repository);
  }
}
