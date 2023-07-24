package com.ss.web.app.enrollment.repository;

import com.ss.web.app.enrollment.Enrollment;
import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;
import com.ss.web.app.utils.Data;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EnrollmentRepoImpl implements EnrollmentRepo {

  private List<Enrollment> college;

  public EnrollmentRepoImpl() {
    college = Data.getCollege();
  }

  @Override
  public List<Student> listStudents(Long idSubject) {
    return college.stream()
            .filter(c -> equalsCode(c.getSubject(), idSubject))
            .map(Enrollment::getStudent)
            .collect(Collectors.toList());
  }

  @Override
  public List<Subject> listSubjects(Long idStudent) {
    return college.stream()
            .filter(c -> equalsId(c.getStudent(), idStudent))
            .map(Enrollment::getSubject)
            .collect(Collectors.toList());
  }

  @Override
  public Student getStudentOf(Long idSubject, Long idStudent) {
    return college.stream()
              .filter(c -> equalsCodeAndId(c, idSubject, idStudent)
              )
              .map(Enrollment::getStudent)
              .findFirst()
              .orElse(null);
  }

  @Override
  public Subject getSubjectOf(Long idStudent, Long idSubject) {
    return college.stream()
            .filter(c -> equalsCodeAndId(c, idSubject, idStudent)
            )
            .map(Enrollment::getSubject)
            .findFirst()
            .orElse(null);
  }

  @Override
  public Enrollment enroll(Long idStudent, Long idSubject) {
    var students = Data.getStudentMap();
    var subjects = Data.getSubjectMap();
    if (students.containsKey(idStudent) && subjects.containsKey(idStudent) ) {
      Enrollment enrollment = new Enrollment(
              subjects.get(idSubject),
              students.get(idStudent));
      Data.getCollege().add(enrollment);
      return enrollment;
    }
    return null;
  }
  private boolean equalsCodeAndId(Enrollment c, Long code, Long id) {
    return equalsId(c.getStudent(), id) && equalsCode(c.getSubject(), code);
  }
  private boolean equalsCode(Subject subject, Long code) {
    return subject.getCode().equals(code);
  }

  private boolean equalsId(Student student, Long id) {
    return student.getId().equals(id);
  }
}
