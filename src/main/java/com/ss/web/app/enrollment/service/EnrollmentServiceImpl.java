package com.ss.web.app.enrollment.service;

import com.ss.web.app.enrollment.Enrollment;
import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;
import com.ss.web.app.enrollment.repository.EnrollmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
  @Autowired
  EnrollmentRepo collegeRepo;

  @Override
  public Enrollment enroll(Long idStudent, Long idSubject) {
    return collegeRepo.enroll(idStudent, idSubject);
  }

  @Override
  public List<Student> findAllStudents(Long id) {
    return collegeRepo.listStudents(id);
  }

  @Override
  public List<Subject> findAllSubjects(Long id) {
    return collegeRepo.listSubjects(id);
  }

  @Override
  public Student getStudentOf(Long idSubject, Long idStudent) {
    return collegeRepo.getStudentOf(idStudent, idSubject);
  }

  @Override
  public Subject getSubjectOf(Long idStudent, Long idSubject) {
    return collegeRepo.getSubjectOf(idStudent, idSubject);
  }
}
