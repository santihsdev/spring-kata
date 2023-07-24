package com.ss.web.app.enrollment.repository;

import com.ss.web.app.enrollment.Enrollment;
import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;

import java.util.List;

public interface EnrollmentRepo {
  Enrollment enroll(Long idStudent, Long idSubject);
  List<Student> listStudents(Long id);
  List<Subject> listSubjects(Long id);
  Student getStudentOf(Long idSubject, Long idStudent);
  Subject getSubjectOf(Long idStudent, Long idSubject);
}
