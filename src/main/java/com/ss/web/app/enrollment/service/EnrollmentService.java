package com.ss.web.app.enrollment.service;

import com.ss.web.app.enrollment.Enrollment;
import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;

import java.util.List;

public interface EnrollmentService {
  Enrollment enroll(Long idStudent, Long idSubject);
  List<Student> findAllStudents(Long id);
  List<Subject> findAllSubjects(Long id);
  Student getStudentOf(Long idSubject, Long idStudent);
  Subject getSubjectOf(Long idStudent, Long idSubject);
}
