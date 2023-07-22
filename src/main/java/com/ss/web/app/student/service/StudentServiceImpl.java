package com.ss.web.app.student.service;

import com.ss.web.app.student.Student;
import com.ss.web.app.utils.Repository;
import com.ss.web.app.utils.service.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<Student> {
  public StudentServiceImpl(Repository<Student> repository) {
    super(repository);
  }
}
