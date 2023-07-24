package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;
import com.ss.web.app.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
  @Autowired
  EnrollmentRepo collegeRepo;

  public EnrollmentServiceImpl(EnrollmentRepo collegeRepo) {
    this.collegeRepo = collegeRepo;
  }

  @Override
  public List<Student> findAllStudents(Long id) {
    return collegeRepo.listStudents(id);
  }

  @Override
  public List<Subject> findAllSubjects(Long id) {
    return collegeRepo.listSubjects(id);
  }
}
