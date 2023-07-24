package com.ss.web.app.service;

import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;

import java.util.List;

public interface EnrollmentService {
  List<Student> findAllStudents(Long id);
  List<Subject> findAllSubjects(Long id);
}
