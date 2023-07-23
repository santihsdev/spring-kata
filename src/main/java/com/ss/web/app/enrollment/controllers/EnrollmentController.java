package com.ss.web.app.enrollment.controllers;

import com.ss.web.app.enrollment.Enrollment;
import com.ss.web.app.student.Student;
import com.ss.web.app.subject.Subject;
import com.ss.web.app.enrollment.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EnrollmentController {
  @Autowired
  private EnrollmentService enrollmentService;

  @GetMapping("/students/{id}/subjects")
  public List<Subject> getSubjects(@PathVariable Long id) {
    return enrollmentService.findAllSubjects(id);
  }

  @GetMapping("/subjects/{id}/students")
  public List<Student> getStudents(@PathVariable Long id) {
    return enrollmentService.findAllStudents(id);
  }

  @GetMapping("/students/{id}/subjects/{idSubject}")
  public Subject getSubjects(@PathVariable Long id, @PathVariable Long idSubject) {
    return enrollmentService.getSubjectOf(id, idSubject);
  }

  @GetMapping("/subjects/{id}/students/{idStudent}")
  public Student getStudents(@PathVariable Long id, @PathVariable Long idStudent) {
    return enrollmentService.getStudentOf(id, idStudent);
  }

  @PostMapping("/subjects/{id}/{idStudent}")
  public Enrollment enrollmentStudent(@PathVariable Long id, @PathVariable Long idStudent) {
    return enrollmentService.enroll(idStudent,id);
  }

  @PostMapping("/students/{id}/{idSubject}")
  public Enrollment enrollmentSubject(@PathVariable Long id, @PathVariable Long idSubject) {
    return enrollmentService.enroll(id, idSubject);
  }
}
