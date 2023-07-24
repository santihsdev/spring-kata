package com.ss.web.app.controllers;

import com.ss.web.app.model.Student;
import com.ss.web.app.model.Subject;
import com.ss.web.app.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
  @Autowired
  EnrollmentService enrollmentService;

  @GetMapping("/student/{id}/class")
  public List<Subject> getSubjects(@PathVariable Long id) {
    return enrollmentService.findAllSubjects(id);
  }

  @GetMapping("/class/{id}/students")
  public List<Student> getStudents(@PathVariable Long id) {
    return enrollmentService.findAllStudents(id);
  }
}
