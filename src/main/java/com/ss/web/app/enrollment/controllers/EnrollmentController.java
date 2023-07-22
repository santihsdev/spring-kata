package com.ss.web.app.enrollment.controllers;

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

  @GetMapping("/student/{id}/class")
  public List<Subject> getSubjects(@PathVariable Long id) {
    return enrollmentService.findAllSubjects(id);
  }

  @GetMapping("/class/{id}/students")
  public List<Student> getStudents(@PathVariable Long id) {
    return enrollmentService.findAllStudents(id);
  }

  @GetMapping("/student/{id}/class/{idClass}")
  public Subject getSubjects(@PathVariable Long id, @PathVariable Long idSubject) {
    return enrollmentService.getSubjectOf(id, idSubject);
  }

  @GetMapping("/class/{id}/students/{idStudent}")
  public Student getStudents(@PathVariable Long id, @PathVariable Long idStudent) {
    return enrollmentService.getStudentOf(id, idStudent);
  }

}
